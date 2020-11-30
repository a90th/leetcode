package to.geekbang;

import org.junit.Test;
import org.omg.CORBA.Object;

public class Lesson09_ArrayQueue<T> {

    private String[] values;
    private int capacity;
    private int head;
    private int tail;
    private int size;

    public Lesson09_ArrayQueue(int capacity) {
        values = new String[capacity];
        this.capacity = capacity;
        this.size = 0;
        this.head = -1;
        this.tail = -1;
    }

    public boolean enqueue(String item) {
        if (size == capacity) return false;
        if (tail == capacity - 1) {
            //搬移
            for (int i = 0; i < size; i++) {
                values[i] = values[head + 1 + i];
            }
            head = -1;
            tail = size - 1;
        }
        tail++;
        values[tail] = item;
        size++;
        return true;
    }

    public String dequeue() {
        if (size == 0) return null;
        size--;
        return values[++head];
    }

    public static class UnitTest {

        @Test
        public void testArrayQueue() {
            Lesson09_ArrayQueue queue = new Lesson09_ArrayQueue(3);
            assert queue.enqueue("xiaohong");
            assert queue.enqueue("zhongming");
            assert queue.enqueue("dabi");
            assert !queue.enqueue("shanji");

            assert "xiaohong".equals(queue.dequeue());
            assert "zhongming".equals(queue.dequeue());
            assert "dabi".equals(queue.dequeue());
            assert null == queue.dequeue();
        }
    }
}
