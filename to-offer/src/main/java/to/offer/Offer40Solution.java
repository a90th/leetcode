package to.offer;

import java.util.Comparator;
import java.util.PriorityQueue;

/***
 * 剑指 Offer 40. 最小的k个数
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 * 示例 1：
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 *
 * 示例 2：
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *
 * 限制：
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 */
public class Offer40Solution {

    public static void main(String[] args) {
//        int[] arr = new int[]{0, 0, 0, 2, 0, 5};
//        int k = 0;
//        int[] result = new to.offer.Offer40Solution().getLeastNumbers2(arr, k);
//        printArray(result);
        int[] arr = new int[]{4, 3, 8, 7, 9, 5, 6};
        int index = new Offer40Solution().partition(arr, 0, arr.length - 1);
        System.out.println(index);
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }

    /**
     * 方法1：使用冒泡排序，只需要找出最小的k个数字
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        int length = arr.length;
        boolean change = true;
        for (int i = 0; i < k; i++) {
            change = false;
            for (int j = length - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    int tmp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = tmp;
                    change = true;
                }
            }
            if (!change) break;
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) result[i] = arr[i];
        return result;
    }

    /**
     * 方法2：不要求结果有正确的排序
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers2(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < arr.length; i++) {
            if (i < k) queue.add(arr[i]);
            else if (!queue.isEmpty() && queue.peek() > arr[i]) {
                queue.remove();
                queue.add(arr[i]);
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = queue.remove();
        }
        return result;
    }

    /**
     * 快排的思想
     * 重点：快速排序的模板
     *
     * @param arr
     * @param k
     * @return
     */
//    public int[] getLeastNumbers3(int[] arr, int k) {
//
//    }
    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    //快速切分，返回下标j，表示arr[j]左边的数字比arr[j]小，arr[j]右边比arr[j]大
    public int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left - 1;
        int j = right;
        while (true) {
            while (++i <= right && arr[i] < pivot) ;
            while (--j >= left && arr[j] > pivot) ;
            if (i >= j) break;
            swap(arr, i, j);
            printArray(arr);
        }
        arr[right] = arr[j];
        arr[j] = pivot;
        return j;
    }

}
