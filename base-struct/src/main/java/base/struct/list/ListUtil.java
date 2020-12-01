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

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            System.out.print(" -> ");
        }
        System.out.println("EDN");
    }
}
