/***
 * 剑指 Offer 11. 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 *
 * 示例 1：
 * 输入：[3,4,5,1,2]
 * 输出：1  
 *
 * 示例 2：
 * 输入：[2,2,2,0,1]
 * 输出：0
 */
public class Offer11Solution {

    public static void main(String[] args) {
        //Step1:基础验证
//        int[] nums = {3, 4, 5, 1, 2};
        int[] nums = {10, 1, 10, 10, 10};
        int result = new Offer11Solution().minArray2(nums);
        System.out.println(result);
    }

    /**
     * 方法1：使用暴力遍历的方法，肯定可以求解，时间复杂度：O(n)
     *
     * @param numbers
     * @return
     */
    public int minArray1(int[] numbers) {
        return 1;
    }

    /**
     * 方法2：考虑数组特点（递增数组+数组旋转）
     * 寻找最大值和最小值问题等价
     *
     * @param numbers
     * @return
     */
    public int minArray2(int[] numbers) {
        if (null == numbers || numbers.length == 0) {
            return 0;
        }
        int leftIndex = 0;
        int rightIndex = numbers.length - 1;
        int middleIndex = (leftIndex + rightIndex) / 2;
        while (rightIndex > leftIndex) {
            if (numbers[leftIndex] < numbers[rightIndex]) {
                return numbers[leftIndex];
            } else {
                middleIndex = (leftIndex + rightIndex) / 2;//可能存在假死，leftIndex没有变化；
                if (numbers[middleIndex] < numbers[rightIndex]) {
                    rightIndex = middleIndex;
                } else if (numbers[middleIndex] == numbers[rightIndex]) {
                    rightIndex--;
                } else {
                    if (leftIndex == middleIndex) {
                        return numbers[rightIndex];
                    } else {
                        leftIndex = middleIndex;
                    }
                }
            }
        }
        return numbers[leftIndex];
    }


}
