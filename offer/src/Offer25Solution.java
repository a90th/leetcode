/***
 * 剑指 Offer 25. 合并两个排序的链表
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * 示例1：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 限制：
 *
 * 0 <= 链表长度 <= 1000
 */
public class Offer25Solution {

    /**
     * 方法1：
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (null == l1) return l2;
        if (null == l2) return l1;
        ListNode pre = new ListNode(-1);
        pre.next = l1.val <= l2.val ? l1 : l2;
        ListNode head = pre.next;

        while (null != l1 && null != l2) {
            if (l1.val > l2.val) {
                ListNode tmp = l2.next;
                pre.next = l2;

                l2 = l1;
                l1 = tmp;
            }
            if (null == l1) {
                pre.next = l2;
            }
            if (null == l2) {
                pre.next = l1;
            }

        }
        return head;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}