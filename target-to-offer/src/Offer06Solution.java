import javafx.scene.layout.BorderImage;

import java.util.Stack;

/***
 * 剑指 Offer 06. 从尾到头打印链表
 *
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * 示例 1：
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *
 * 限制：
 * 0 <= 链表长度 <= 10000
 *
 * 重点考察对栈的理解
 */
public class Offer06Solution {
    public static void main(String[] args) {
        //Step1:基础验证

    }


    /**
     * 方法1： 正向遍历链表，逆向放入数组
     * 时间复杂度：O(n)
     * 空间耗用：O(n)
     *
     * @param head
     * @return
     */
    public int[] reversePrint1(ListNode head) {
        int listSize = 0;
        for (ListNode point = head; null != point; point = point.next) {
            listSize = listSize + 1;
        }
        int[] reverseList = new int[listSize];
        int index = listSize - 1;
        for (ListNode point = head; null != point; point = point.next) {
            reverseList[index--] = point.val;
        }
        return reverseList;
    }

    /**
     * 方法2：官方解法，使用栈先进后出，实现反转
     * 时间复杂度：O(n), 从栈弹出，相当于多了一次遍历
     * 空间耗用：O(n), 额外一份存储空间
     *
     * @param head
     * @return
     */
    public int[] reversePrint2(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        for (ListNode point = head; null != point; point = point.next) {
            stack.push(point);
        }
        int[] print = new int[stack.size()];
        for (int index = 0; index < print.length; index++) {
            print[index]=stack.pop().val;
        }
        return print;
    }

    class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            this.val = x;
        }
    }
}
