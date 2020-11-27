package to.offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/***
 * 剑指 Offer 30. 包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，
 * 调用 min、push 及 pop 的时间复杂度都是 O(1)。
 *
 * 示例:
 * to.offer.MinStack minStack = new to.offer.MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 *  
 *
 * 提示：
 * 各函数的调用总次数不超过 20000 次
 */
public class Offer30Solution {
}

class MinStack {
    Stack<Integer> datas;
    Stack<Integer> min;

    public MinStack() {
        datas = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        datas.push(x);
        if (min.isEmpty() || x <= min.peek()) {
            min.push(x);
        }
    }

    public void pop() {
        int num = datas.pop();
        if (!min.isEmpty() && num == min.peek()) min.pop();
    }

    public int top() {
        return datas.peek();
    }

    public int min() {
        return min.peek();
    }
}
