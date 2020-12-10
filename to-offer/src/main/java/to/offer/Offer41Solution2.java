package to.offer;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Offer41Solution2 {
    class MedianFinder {
        private int size = 0;
        private PriorityQueue<Integer> leftHeap;
        private PriorityQueue<Integer> rightHeap;

        public MedianFinder() {
            size = 0;
            leftHeap = new PriorityQueue<>();
            rightHeap = new PriorityQueue<>((o1, o2) -> (o2 - o1));
        }

        public void addNum(int num) {
            if (leftHeap.size() != rightHeap.size()) {
                rightHeap.add(num);
                leftHeap.add(rightHeap.poll());
            } else {
                leftHeap.add(num);
                rightHeap.add(leftHeap.poll());
            }
        }

        public double findMedian() {
            if (leftHeap.size() != rightHeap.size()) return rightHeap.peek();
            else return (leftHeap.peek() + rightHeap.peek()) / 2.0;
        }
    }
}
