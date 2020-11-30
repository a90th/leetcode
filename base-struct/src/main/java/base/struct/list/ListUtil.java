package base.struct.list;

public class ListUtil {
    public static void printLinkedList(LinkedNode head) {
        while (null != head) {
            System.out.print(head.val);
            System.out.print(" -> ");
            head = head.next;
        }
        System.out.println("null");
    }
}
