package to.offer;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * <p>
 * 示例 1:
 * 输入: [10,2]
 * 输出: "102"
 * 示例 2:
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 * <p>
 * 提示:
 * 0 < nums.length <= 100
 * 说明:
 * 输出结果可能非常大，所以你需要返回一个字符串而不是整数
 * 拼接起来的数字可能会有前导0，最后结果不需要去掉前导0
 */
public class Offer45Solution {

    //就是按照某个要求排序；
    //可以使用递归方法，挑选首位最小的数字
    public static String minNumber(int[] nums) {
        String[] numsStr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) numsStr[i] = String.valueOf(nums[i]);
        Arrays.sort(numsStr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                long a = Long.valueOf(o1 + o2);
                long b = Long.valueOf(o2 + o1);
                return a > b ? 1 : a == b ? 0 : -1;
            }
        });
        StringBuilder builder = new StringBuilder("");
        for (int i = 0; i < numsStr.length; i++) builder.append(numsStr[i]);
        return builder.toString();
    }


    public static void main(String[] args) {
        int[] input = {3, 30, 34, 5, 9};
        String result = minNumber(input);
        System.out.print(result);
    }

}
