package to.offer;

/***
 * 剑指 Offer 03. 数组中重复的数字
 * 找出数组中重复的数字。
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * 示例 1：
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *
 * 限制：
 *
 * 2 <= n <= 100000
 */
public class Offer03Solution {

    public static void main(String[] args) {
        //Step1:基础验证
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        int result = new Offer03Solution().findRepeatNumber2(nums);
        System.out.println(result);
    }


    /**
     * 方法1：暴力遍历，比较
     * <p>
     * 时间复杂度O(n^2)
     * 空间耗用=0
     *
     * @param nums
     * @return
     */
    public int findRepeatNumber1(int[] nums) {
        boolean hit = false;
        for (int i = 0; i < nums.length; i++) {
            int headNum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int currentNum = nums[j];
                if (headNum == currentNum) {
                    return headNum;
                }
            }
        }
        return -1;
    }

    /**
     * 方法2： 创建新数组，数据暂存
     * <p>
     * 时间复杂度O(n)
     * 空间耗用=n
     *
     * @param nums
     * @return
     */
    public int findRepeatNumber2(int[] nums) {
        int[] copyNums = new int[nums.length];
        for (int i = 0; i < copyNums.length; i++) {
            copyNums[i] = 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (copyNums[nums[i]] == 0) copyNums[nums[i]]++;
            else return nums[i];
        }
        return -1;
    }

    /**
     * 官方方法： 使用Hash集合Set，判断添加是否存在重复
     * 时间复杂度O(n)
     * 空间耗用O(n)
     *
     * @param nums
     * @return
     */
    public int findRepeatNumber3(int[] nums) {
        int[] copyNums = new int[nums.length];
        for (int i = 0; i < copyNums.length; i++) {
            copyNums[i] = 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (copyNums[nums[i]] == 0) copyNums[nums[i]]++;
            else return nums[i];
        }
        return -1;
    }
}