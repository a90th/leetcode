package to.geekbang;

import base.struct.list.ListUtil;
import org.junit.Test;

public class Lesson12_Sort {

    //归并排序
    //稳定的排序
    //非原地排序
    //时间复杂度O(nlogn)
    //实现从小到达排序
    public static void mergeSort(int[] array) {

    }

    //快速排序
    //非稳定排序
    //原地排序
    //时间复杂度：
    //实现从小到大排序
    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    public static void quickSort(int[] array, int start, int end) {
        if (start < 0 || end > array.length - 1 || end - start < 1) return;
        int pivot = array[end];
        int i = start;
        for (int j = i; j < end; j++) {
            if (array[j] < pivot) {
                int temp = array[j];
                array[j] = array[i];
                array[i] = temp;
                i++;//指向第一个大于pivot的元素
            }
        }
        array[end] = array[i];
        array[i] = pivot;
        quickSort(array, start, i - 1);
        quickSort(array, i + 1, end);
    }

    //寻找第k小的数字
    public static int topK(int[] array, int k) {
        int index = topK(array, k, 0, array.length - 1);
        if (-1 == index) throw new IllegalArgumentException();
        else return array[index];
    }

    //返回数组下标
    public static int topK(int[] array, int k, int start, int end) {
        if (start < 0 || end > array.length - 1
                || end - start < 1 || k < start + 1
                || k > end + 1) return -1;
        int pivot = array[end];
        int i = start;
        for (int j = i; j < end; j++) {
            if (array[j] < pivot) {
                int temp = array[j];
                array[j] = array[i];
                array[i] = temp;
                i++;//指向第一个大于pivot的元素
            }
        }
        array[end] = array[i];
        array[i] = pivot;
        if (i == k - 1) return i;
        else if (i > k - 1) return topK(array, k, start, i - 1);
        else return topK(array, k, i + 1, end);
    }


    public static class UnitTest {

        @Test
        public void testQuickSort() {
            int[] array = {7, 6, 5, 4, 3, 2, 1};
            ListUtil.printArray(array);
//            quickSort(array);
//            ListUtil.printArray(array);
            int top3=topK(array,3);
            System.out.println(top3);

            int top10=topK(array,4);
            System.out.println(top10);
        }
    }

}
