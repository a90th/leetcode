package to.geekbang;

import org.junit.Test;

/**
 * 二分查找的变体方法
 */
public class Lesson16_BSearch {

    //返回第一个目标值的下标
    public static int firstTargetNum(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (array[mid] == target) {
                if (0 == mid || array[mid - 1] != target) return mid;
                else {
                    right = mid - 1;
                }
            } else if (array[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    //返回最后一个目标值下标
    public static int lastTargetNum(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (array[mid] == target) {
                if (array.length - 1 == mid || array[mid + 1] != target) return mid;
                else {
                    left = mid + 1;
                }
            } else if (array[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    //返回第一个大于目标值的下标
    public static int firstGreaterNum(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (array[mid] > target) {
                if (mid == 0 || array[mid - 1] <= target) return mid;
                else {
                    right = mid - 1;
                }
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }


    //返回最后一个小于目标值的下标
    public static int lastSmallerNum(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (array[mid] < target) {
                if (mid == array.length - 1 || array[mid + 1] >= target) return mid;
                else {
                    left = mid + 1;
                }
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    //循环有序数组中查找目标值
    //可以借助mid的值判断最小值的位置，确定数组的形态
    public static int bSearch(int[] circleArray, int target) {
        int left = 0;
        int right = circleArray.length - 1;

        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (circleArray[mid] == target) {
                return mid;
            } else if (circleArray[mid] < target) {
                if (circleArray[left] < circleArray[right] || circleArray[right] >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (circleArray[left] < circleArray[right] || circleArray[left] <= target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }


    public static class UnitTest {

        @Test
        public void testFirstTargetNum() {
            int[] array = {1, 2, 3, 4, 4, 5, 6, 6, 6, 7, 9, 10};

            int index = firstTargetNum(array, 6);
            System.out.println(index);

            int index2 = lastTargetNum(array, 4);
            System.out.println(index2);

            int index3 = firstGreaterNum(array, 5);
            System.out.println(index3);

            int index4 = lastSmallerNum(array, 12);
            System.out.println(index4);
        }

        @Test
        public void testCircleArray() {
            int[] array = {4, 5, 6, 7, 1, 1, 2, 2, 3, 4};
            int index = bSearch(array, 5);
            System.out.print(index);
        }
    }

}
