package to.offer;

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
     * 方法1：选择小的节点放到新的队列
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (null == l1) return l2;
        if (null == l2) return l1;
        ListNode head = null;
        //相似代码，应该合并
        if (l1.val <= l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }
        ListNode point = head;
        while (null != l1 && null != l2) {
            if (l1.val <= l2.val) {
                point.next = l1;
                l1 = l1.next;
            } else {
                point.next = l2;
                l2 = l2.next;
            }
            point = point.next;
        }
        if (null == l1 && null != l2) {
            point.next = l2;
        }
        if (null != l1 && null == l2) {
            point.next = l1;
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

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (null == l1) return l2;
        if (null == l2) return l1;
        ListNode drum = new ListNode(0);
        ListNode point = drum;
        while (null != l1 && null != l2) {
            if (l1.val <= l2.val) {
                point.next = l1;
                l1 = l1.next;
            } else {
                point.next = l2;
                l2 = l2.next;
            }
            point = point.next;
        }
        if (null == l1 && null != l2) {
            point.next = l2;
        }
        if (null != l1 && null == l2) {
            point.next = l1;
        }
        return drum.next;
    }
}