package to.offer;

/**
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
 * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * 示例 1:
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 */
public class Offer46Solution {

    //递归方法
    //主要的低效表现在重复计算、调用深度；
    public static int translateNum(int num) {
        if (num < 10) return 1;
        if (num % 100 > 9 && num % 100 < 26) {
            return translateNum(num / 100) + translateNum(num / 10);
        } else {
            return translateNum(num / 10);
        }
    }

    //动态规划
    //从后往前取各个位
    //假设不存在连续3个数字相同
    public static int translateNum2(int num) {
        if (num < 10) return 1;
        int count1 = 1;
        int count2 = 0;

        while (num >= 10) {
            int lastPos = num % 10;
            num /= 10;
            int currentPos = num % 10;
            int tmp = currentPos * 10 + lastPos;
            if (tmp >= 10 && tmp < 26) {
                tmp = count1;
                count1 = count2 + count1;
                count2 = tmp;
            } else {
                count1 = count2 + count1;
                count2=0;
            }
        }
        return count1 + count2;
    }

    public static void main(String[] args) {
        int input = 18822;
        System.out.print(translateNum2(input));
    }
}
