package to.geekbang;

import org.junit.Test;

import java.util.Stack;

//栈的典型应用场景：
//1. 函数调用中存储栈帧
//2. 表达是求值
public class Lesson08_ExpressionCompute {

    //约定数字、运算符之间通过" "间隔，方便表达式的分割
    //表达式以$结尾
    public static int computeExp(String expression) {
        String[] ops = expression.split(" ");
        Stack<Integer> numStack = new Stack<>();
        Stack<Ops> opStack = new Stack<>();

        for (int i = 0; i < ops.length; i++) {
            if (!ops[i].equals("+") && !ops[i].equals("-") && !ops[i].equals("*") && !ops[i].equals("/") && !ops[i].equals("$")) {
                numStack.push(Integer.valueOf(ops[i]));
            } else {
                Ops currentOp = ops[i].equals("+") ? Ops.ADD : ops[i].equals("-") ? Ops.MINUS : ops[i].equals("*") ? Ops.MULTIPLE : ops[i].equals("/") ? Ops.DIVIDE : ops[i].equals("$") ? Ops.END : null;
                if (opStack.isEmpty() || opStack.peek().value < currentOp.value) {
                    opStack.push(currentOp);
                } else {
                    //正常表达式不会积累之前应该计算的结果没有计算
                    //这里适应 '$' 运算符触发结束计算
                    while (!opStack.isEmpty() && opStack.peek().value >= currentOp.value) {
                        Integer late = numStack.pop();
                        Integer prev = numStack.pop();
                        Ops lastOp = opStack.pop();
                        Integer result = 0;
                        switch (lastOp) {
                            case ADD:
                                result = prev + late;
                                break;
                            case MINUS:
                                result = prev - late;
                                break;
                            case DIVIDE:
                                result = prev / late;
                                break;
                            case MULTIPLE:
                                result = prev * late;
                                break;
                        }
                        numStack.push(result);
                    }

                    opStack.push(currentOp);
                }
            }
        }
        return numStack.pop();
    }


    public static class UnitTest {

        @Test
        public void testExpCompute() {
            String expression = "1 + 2 * 3 $";
            Integer result = computeExp(expression);
            System.out.println(result);
            assert 7 == result;
        }
    }
}

enum Ops {
    ADD(1),
    MINUS(1),
    MULTIPLE(2),
    DIVIDE(2),
    END(0);

    public int value;

    Ops(int value) {
        this.value = value;
    }

}