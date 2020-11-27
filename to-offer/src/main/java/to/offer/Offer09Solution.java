package to.offer;

import java.util.Stack;

/***
 * 剑指 Offer 09. 用两个栈实现队列
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 * 示例 1：
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 *
 * 示例 2：
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 *
 * 提示：
 * 1 <= values <= 10000
 * 最多会对 appendTail、deleteHead 进行 10000 次调用
 */
public class Offer09Solution {

    public static void main(String[] args) {
        //基础验证
        CQueue queue = new Offer09Solution().new CQueue();
        queue.appendTail(3);
        assert 3 == queue.deleteHead();
        assert -1 == queue.deleteHead();
    }

    /**
     * 方法1：使用栈的逆序功能
     */
    class CQueue {

        private Stack<Integer> leftStack;
        private Stack<Integer> rightStack;

        public CQueue() {
            leftStack = new Stack<>();
            rightStack = new Stack<>();
        }

        public void appendTail(int value) {
            leftStack.push(value);
        }

        public int deleteHead() {
            if (leftStack.empty()) {
                return -1;
            }
            while (!leftStack.empty()) {
                rightStack.push(leftStack.pop());
            }
            int leftHead = rightStack.pop();
            while (!rightStack.empty()) {
                leftStack.push(rightStack.pop());
            }
            return leftHead;
        }
    }

    /**
     * 官方解法
     * 在方法1上优化，不是每次出栈都进行复制
     */
    class CQueue1 {

        private Stack<Integer> leftStack;
        private Stack<Integer> rightStack;

        public CQueue1() {
            leftStack = new Stack<>();
            rightStack = new Stack<>();
        }

        public void appendTail(int value) {
            leftStack.push(value);
        }

        public int deleteHead() {
            if (!rightStack.isEmpty()) return rightStack.pop();
            else {
                while (!leftStack.empty()) {
                    rightStack.push(leftStack.pop());
                }
                if (rightStack.empty()) {
                    return -1;
                } else {
                    return rightStack.pop();
                }
            }
        }
    }
}
