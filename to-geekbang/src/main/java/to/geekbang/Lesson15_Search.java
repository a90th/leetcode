package to.geekbang;

import org.junit.Test;

public class Lesson15_Search {

    //返回目标值的下标
    //数组已经按照从小到达排序
    public static int bSearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            //>>运算符的优先级比+要低
            int mid = left + ((right - left) >> 1);
            if (target == array[mid]) {
                return mid;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    //二分查找的递归实现
    public static int bSearch(int[] array, int start, int end, int target) {
        if (start > end) return -1;
        int mid = start + ((end - start) >> 1);
        if (array[mid] == target) return mid;
        else if (array[mid] < target) {
            return bSearch(array, mid + 1, end, target);
        } else {
            return bSearch(array, start, mid - 1, target);
        }
    }

    //求取平方根
    public static double squareRoot(double num) {
        double low, high, mid;
        if (num > 1) {
            low = 1;
            high = num;
        } else if (num > 0) {
            low = num;
            high = 1;
        } else {
            throw new IllegalArgumentException();
        }
        while (low < high) {
            mid = (low + high) / 2;
            double mid_2 = mid * mid;
            if (num - mid_2 < 1e-6 && mid_2 - num < 1e-06) {
                return mid;
            } else if (num > mid_2) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return -1;
    }


    public static class UnitTest {

        @Test
        public void testBSearch() {
            int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
            int index = bSearch(array, 6);
            System.out.println(index);

            int index2 = bSearch(array, 0, array.length - 1, 10);
            System.out.println(index2);

            double result=squareRoot(0.3);
            System.out.println(result);
        }

    }
}
