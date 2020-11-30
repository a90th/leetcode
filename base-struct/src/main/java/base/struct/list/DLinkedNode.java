package base.struct.list;

public class DLinkedNode {
    public int val;
    public DLinkedNode pre;
    public DLinkedNode next;

    public DLinkedNode(int val, DLinkedNode pre, DLinkedNode next) {
        this.val = val;
        this.pre = pre;
        this.next = next;
    }
}
