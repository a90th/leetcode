import java.util.Stack;

/***
 * 剑指 Offer 24. 反转链表
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *  
 * 限制：
 * 0 <= 节点个数 <= 5000
 */
public class Offer24Solution {
    /**
     * 方法1：使用栈实现反转
     * ERROR 没有实现反转
     * 栈已经对节点进行了存储，只需重建链表
     *
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
        if (null == head) return head;
        Stack<ListNode> stack = new Stack<>();
        while (null != head) {
            stack.push(head);
            head = head.next;
        }
//        head=stack.pop();
//        while (!stack.empty()) {
//            ListNode node = stack.pop();
//            node.next = head;
//            head = node;
//        }
        head = stack.pop();
        ListNode tail = head;
        while (!stack.empty()) {
            tail.next = stack.pop();
            tail = tail.next;
        }
        tail.next = null;
        return head;
    }

    /**
     * 方法2：直接反转节点间的指针关系
     *
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if (null == head) return null;
        //跟踪链表头两个节点
        ListNode current = head;
        ListNode next = current.next;
        //头节点最终作为尾节点，head.next=null；
        current.next = null;

        //遍历
        while (null != next) {
            //记录第三个节点
            ListNode tmp = next.next;
            //反转指针
            next.next = current;

            //遍历后移，这里也保证了current!=null
            current = next;
            next = tmp;
        }
        return current;
    }


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
