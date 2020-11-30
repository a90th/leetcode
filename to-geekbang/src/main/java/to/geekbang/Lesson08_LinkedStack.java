package to.geekbang;

import base.struct.list.LinkedNode;
import org.junit.Test;

public class Lesson08_LinkedStack {
    private LinkedNode head;//带头链表
    private int capacity;
    private int size;

    public Lesson08_LinkedStack(int capacity) {
        head = new LinkedNode(-1, null);
        this.capacity = capacity;
        this.size = 0;
    }

    public boolean push(int item) {
        if (size == capacity) return false;
        else {
            LinkedNode newNode = new LinkedNode(item, head.next);
            head.next = newNode;
            size++;
            return true;
        }
    }

    public int pop() {
        if (size == 0) return -1;
        else {
            LinkedNode top = head.next;
            head.next = top.next;
            size--;
            return top.val;
        }
    }

    public static class UnitTest {

        @Test
        public void testStackOps() {
            Lesson08_LinkedStack stack=new Lesson08_LinkedStack(3);
            assert stack.push(1);
            assert stack.push(2);
            assert stack.push(3);
            assert !stack.push(5);

            assert 3==stack.pop();
            assert 2==stack.pop();
            assert 1==stack.pop();
            assert -1==stack.pop();
        }
    }
}
