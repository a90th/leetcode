package to.geekbang;

import base.struct.list.LinkedNode;
import base.struct.list.ListUtil;
import org.junit.Test;

import java.util.HashSet;

//使用哨兵实现带头链表，本节未实现

public class Lesson07_LinkedList {
    //反转链表
    //时间复杂度O(n)
    //不带头列表
    public static LinkedNode revertLink(LinkedNode head) {
        if (null == head || null == head.next) return head;
        LinkedNode pre = null;
        while (null != head) {
            LinkedNode tmp = head;
            head = head.next;
            //反转指针
            tmp.next = pre;
            pre = tmp;
        }

        return pre;
    }

    //链表中环的检测
    public static boolean hasLoopInLikedList(LinkedNode head) {
        if (null == head || null == head.next) return false;
        //原来使用TreeSet，但是TreeSet要求comparator
        HashSet<LinkedNode> visited = new HashSet<>();
        while (null != head.next) {
            if (visited.contains(head)) return true;
            visited.add(head);
            head = head.next;
        }
        return false;
    }

    //有序链表合并，假设原链表增序排列
    //插入的方式，一段链表的插入，区别于数组的合并，不需要处理最终某个链剩余结点的合并，因为链表天然连接下一个结点
    public static LinkedNode combineList(LinkedNode head1, LinkedNode head2) {
        if (null == head1) return head2;
        if (null == head2) return head1;

        LinkedNode head = head1.val < head2.val ? head1 : head2;
        while (null != head1 && null != head2) {
            if (head1.val < head2.val) {
                while (null != head1.next && head1.next.val < head2.val) head1 = head1.next;
                LinkedNode tmp = head1.next;
                head1.next = head2;
                head2 = tmp;
            } else {
                while (null != head2.next && head1.next.val >= head2.val) head2 = head2.next;
                LinkedNode tmp = head2.next;
                head2.next = head1;
                head1 = tmp;
            }
        }
        return head;
    }

    //删除链表中倒数第n个节点
    //跟随指针方案
    public static LinkedNode removeBackNthNode(LinkedNode head, int n) {
        if (null == head || n <= 0) return head;
        LinkedNode front = head;
        LinkedNode backPre = head;
        for (int i = n; i > 0; i--) {
            if (null == front.next) return head;
            front = front.next;
        }
        while (null != front.next) {
            front = front.next;
            backPre = backPre.next;
        }
        backPre.next = backPre.next.next;
        return head;
    }

    //求链表的中间节点
    //快慢指针方案
    public static LinkedNode theMidNode(LinkedNode head) {
        if (null == head || null == head.next || null == head.next.next) return null;
        LinkedNode slow = head;
        LinkedNode fast = head;
        while (null != fast && null != fast.next) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (null == fast) return null;
        else return slow;
    }

    public static class UnitTest {

        @Test
        public void testPrintLinkedList() {
            LinkedNode node1 = new LinkedNode(1, null);
            LinkedNode node2 = new LinkedNode(2, node1);
            LinkedNode node3 = new LinkedNode(3, node2);
            LinkedNode node4 = new LinkedNode(4, node3);
            LinkedNode node5 = new LinkedNode(5, node4);

            LinkedNode head = node5;

            ListUtil.printLinkedList(head);

            head = revertLink(head);
            ListUtil.printLinkedList(head);
        }

        @Test
        public void testLoopTest() {
            LinkedNode node1 = new LinkedNode(1, null);
            LinkedNode node2 = new LinkedNode(2, node1);
            LinkedNode node3 = new LinkedNode(3, node2);
            LinkedNode node4 = new LinkedNode(4, node3);
            LinkedNode node5 = new LinkedNode(5, node4);
            node1.next = node5;

            LinkedNode head = node3;
            assert hasLoopInLikedList(head);
        }

        @Test
        public void testCombineList() {
            LinkedNode node1 = new LinkedNode(9, null);
            LinkedNode node2 = new LinkedNode(7, node1);
            LinkedNode node3 = new LinkedNode(5, node2);
            LinkedNode node4 = new LinkedNode(3, node3);
            LinkedNode node5 = new LinkedNode(1, node4);
            LinkedNode head1 = node5;

            ListUtil.printLinkedList(head1);

            node1 = new LinkedNode(10, null);
            node2 = new LinkedNode(8, node1);
            node3 = new LinkedNode(6, node2);
            node4 = new LinkedNode(4, node3);
            node5 = new LinkedNode(2, node4);
            LinkedNode head2 = node5;

            ListUtil.printLinkedList(head2);

            LinkedNode newHead = combineList(head1, head2);
            ListUtil.printLinkedList(newHead);
        }

        @Test
        public void testRemoveBackNthNode() {
            LinkedNode node1 = new LinkedNode(9, null);
            LinkedNode node2 = new LinkedNode(7, node1);
            LinkedNode node3 = new LinkedNode(5, node2);
            LinkedNode node4 = new LinkedNode(3, node3);
            LinkedNode node5 = new LinkedNode(1, node4);
            LinkedNode head1 = node5;

            ListUtil.printLinkedList(head1);

            head1 = removeBackNthNode(head1, 2);
            ListUtil.printLinkedList(head1);
        }

        @Test
        public void testTheMidNode() {
            LinkedNode node1 = new LinkedNode(9, null);
            LinkedNode node2 = new LinkedNode(7, node1);
            LinkedNode node3 = new LinkedNode(5, node2);
            LinkedNode node4 = new LinkedNode(3, node3);
            LinkedNode node5 = new LinkedNode(1, node4);
            LinkedNode head1 = node4;

            ListUtil.printLinkedList(head1);

            LinkedNode mid = theMidNode(head1);
            assert null==mid;
        }
    }


}