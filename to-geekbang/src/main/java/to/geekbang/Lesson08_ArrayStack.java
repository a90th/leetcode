package to.geekbang;

import org.junit.Test;

public class Lesson08_ArrayStack {
    private String[] items;
    private int capacity;
    private int size;

    public Lesson08_ArrayStack(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.items = new String[this.capacity];
    }

    public boolean push(String item) {
        if (size == capacity) return false;
        else {
            items[size++] = item;
            return true;
        }
    }

    public String pop() {
        if (size == 0) return null;
        return items[--size];
    }

    public static class UnitTest {

        @Test
        public void testStackOps() {
            Lesson08_ArrayStack stack=new Lesson08_ArrayStack(3);
            assert stack.push("xiaoming");
            assert stack.push("zhongming");
            assert stack.push("wangliang");
            assert !stack.push("dami");

            assert "wangliang".equals(stack.pop());
            assert "zhongming".equals(stack.pop());
            assert "xiaoming".equals(stack.pop());
            assert null==stack.pop();
        }
    }
}
