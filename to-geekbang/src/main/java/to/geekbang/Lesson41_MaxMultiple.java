package to.geekbang;

import org.junit.Test;

public class Lesson41_MaxMultiple {

    public static int findMaxProductSubArrays(int[] nums) {
        if (null == nums || nums.length == 0) return 0;
        int result = nums[0];
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        max[0] = nums[0];
        min[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max[i] = Math.max(Math.max(max[i - 1] * nums[i], min[i - 1] * nums[i]), nums[i]);
            min[i] = Math.min(Math.min(max[i - 1] * nums[i], min[i - 1] * nums[i]), nums[i]);
            result = Math.max(result, Math.max(max[i], min[i]));
        }
        return result;
    }


    public static class UnitTest {

        @Test
        public void test() {
            int[] nums = new int[]{-3, -2, -4, -1, -1, 5};
            assert 40 == findMaxProductSubArrays(nums);

            int[] nums2 = new int[]{-3, -2, -4, -1, 0, 5};
            assert 24 == findMaxProductSubArrays(nums2);
        }

    }
}
