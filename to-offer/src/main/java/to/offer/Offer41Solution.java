package to.offer;

/**
 * 如何得到一个数据流中的中位数？
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * <p>
 * 例如，
 * [2,3,4] 的中位数是 3
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * <p>
 * 设计一个支持以下两种操作的数据结构：
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * <p>
 * 示例 1：
 * 输入：
 * ["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
 * [[],[1],[2],[],[3],[]]
 * 输出：[null,null,null,1.50000,null,2.00000]
 * 示例 2：
 * <p>
 * 输入：
 * ["MedianFinder","addNum","findMedian","addNum","findMedian"]
 * [[],[2],[],[3],[]]
 * 输出：[null,null,2.00000,null,2.50000]
 */
public class Offer41Solution {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }

}


class MedianFinder {
    private int[] nums;
    private int size;
    private int midIndex;
    private int capacity = 16;

    private boolean growSize() {
        if (capacity >= Integer.MAX_VALUE >> 3) return false;
        if (size < capacity) return true;
        capacity = capacity << 1;
        int[] newNums = new int[capacity];
        for (int i = 0; i < size; i++) {
            newNums[i] = nums[i];
        }
        nums = newNums;
        return true;
    }

    public MedianFinder() {
        nums = new int[capacity];
        size = 0;
        midIndex = -1;
    }

    public void addNum(int num) {
        if (size == capacity) growSize();
        //插入排序思想查找位置，因为插入的复杂度已经是O(n)
        int i = size;
        for (; i > 0 && nums[i - 1] > num; i--) {
            nums[i] = nums[i - 1];
        }
        nums[i] = num;
        size++;
        midIndex = (size - 1) / 2;
    }

    public double findMedian() {
        if (0 == size % 2) return ((double) nums[midIndex] + (double) nums[midIndex + 1]) / 2;
        else return nums[midIndex];
    }
}
