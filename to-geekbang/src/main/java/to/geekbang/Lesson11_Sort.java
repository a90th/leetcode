package to.geekbang;

import base.struct.list.ListUtil;
import org.junit.Test;

/**
 * 顺序表排序
 * 随机访问特性
 */
public class Lesson11_Sort {

    //冒泡排序
    //实现从小到大排序
    //原地排序，空间复杂度O(1)
    //稳定排序
    //时间复杂度：最好O(1)，最差O(n^2)，均摊时间复杂度O(n^2)
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            boolean change = false;
            for (int j = array.length - 1; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    int tmp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = tmp;
                    change = true;
                }
            }
            if (!change) break;
        }
    }

    //插入排序
    //实现从小到大排序
    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
//            //可以使用交换的方法
//            for (int j = i; j > 0; j--) {
//                if (array[j] < array[j - 1]) {
//                    int tmp = array[j];
//                    array[j] = array[j - 1];
//                    array[j - 1] = tmp;
//                }
//            }
            //最好使用移动的方式
            int j = i;
            int itemJ = array[j];
            for (; j > 0; j--) {
                if (array[j - 1] > itemJ) {
                    array[j] = array[j - 1];
                } else {
                    break;
                }
            }
            array[j] = itemJ;
        }
    }

    //选择排序
    //实现从小到达排序
    //不稳定排序
    //时间复杂度O(n^2)
    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            int min = array[i];
            for (int j = minIndex + 1; j < array.length; j++) {
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                array[i] = array[minIndex];
                array[minIndex] = min;
            }

        }
    }


    public static class UnitTest {

        @Test
        public void testBubbleSort() {
            int[] array = {7, 6, 5, 4, 3, 2, 1};
            ListUtil.printArray(array);
//            bubbleSort(array);
//            insertSort(array);
            selectSort(array);
            ListUtil.printArray(array);
        }
    }
}
