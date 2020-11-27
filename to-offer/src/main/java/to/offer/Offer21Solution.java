package to.offer;

/***
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 * 示例：
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 *  
 * 提示：
 * 1 <= nums.length <= 50000
 * 1 <= nums[i] <= 10000
 */
public class Offer21Solution {

    public static void main(String[] args) {
        //基础验证
        int[] nums = new int[]{1, 2, 3, 4};
//        new to.offer.Offer21Solution().printArray(nums);
        new Offer21Solution().exchange(nums);
        new Offer21Solution().printArray(nums);
    }

    /**
     * 方法1：两端搜索，交换数字的位置
     * @param nums
     * @return
     */
    public int[] exchange(int[] nums) {
        if (null == nums || nums.length == 0) {
            return nums;
        }
        int head = 0;
        int tail = nums.length - 1;
        while (head < tail) {
            while (head < tail && nums[head] % 2 != 0) {
                head++;
            }
            while (head < tail && nums[tail] % 2 == 0) {
                tail--;
            }
            if (head < tail) {
                int tmp = nums[head];
                nums[head] = nums[tail];
                nums[tail] = tmp;
            } else {
                break;
            }
        }
        return nums;
    }

    public void printArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + "\t");
        }
    }
}
