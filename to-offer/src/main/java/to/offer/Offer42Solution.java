package to.offer;

/**
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。
 * 求所有子数组的和的最大值。
 * <p>
 * 要求时间复杂度为O(n)。
 * 示例1:
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * <p>
 * 提示：
 * 1 <= arr.length <= 10^5
 * -100 <= arr[i] <= 100
 */
public class Offer42Solution {

    public static void main(String[] args) {
        int[] array = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result = maxSubArray2(array);
        System.out.print(result);
    }


    //使用动态规划解决
    //结果正确，但是内存使用超限
    public static int maxSubArray(int[] array) {
        int arrayLength = array.length;
        int[][] sums = new int[arrayLength][arrayLength];
        int maxSum = array[0];
        for (int i = 0; i < arrayLength; i++) {
            for (int j = i; j < arrayLength; j++) {
                if (i == j) sums[i][j] = array[i];
                else {
                    sums[i][j] = sums[i][j - 1] + array[j];
                }
                if (sums[i][j] > maxSum) maxSum = sums[i][j];
            }
        }
        return maxSum;
    }

    public static int maxSubArray2(int[] nums) {
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0) nums[i] += nums[i - 1];
            if (nums[i] > maxSum) maxSum = nums[i];
        }
        return maxSum;
    }

    public static int maxSUbArray2(int[] nums) {
        int maxSum = nums[0];
        int leftSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (leftSum > 0) leftSum = leftSum + nums[i];
            else {
                leftSum = nums[i];
            }
            if (leftSum > maxSum) maxSum = leftSum;
        }
        return maxSum;
    }
}
