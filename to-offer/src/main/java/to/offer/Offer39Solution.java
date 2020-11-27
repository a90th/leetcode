package to.offer;

import java.util.HashMap;
import java.util.Map;

/***
 * 剑指 Offer 39. 数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例 1:
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 *
 * 限制：
 * 1 <= 数组长度 <= 50000
 */
public class Offer39Solution {

    /**
     * 方法1：暴力解法，遍历累计
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (null == count.get(nums[i]))
                count.put(nums[i], 0);
            count.put(nums[i], count.get(nums[i]) + 1);
            if (count.get(nums[i]) > nums.length / 2) return nums[i];
        }
        return -1;
    }

    /**
     * 方法2：进行排序，数量超过一半的数字必然出现在length/2+1未知上
     * 可以使用复杂度为n*log(n)的算法
     *
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        return start;
    }

    /**
     * 方法3：摩尔投票法
     * 1, 2, 3, 2, 2, 2, 5, 4, 2
     * 1,-1,
     *       1,-1,
     *             1, 1,-1,-1,
     *                         1
     * 时间复杂度为O(N)，空间复杂度O(1)
     * @param nums
     * @return
     */
    public int majorityElement3(int[] nums) {
        int result = 0;
        int votes = 0;
        for (int num : nums) {
            if (0 == votes) result = num;
            votes += result == num ? 1 : -1;
        }
        return result;
    }
}
