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
     * 方法
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
    }
}
