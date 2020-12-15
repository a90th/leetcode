package to.offer;

/**
 * 输入一个整数n ，求1～n这n个整数的十进制表示中1出现的次数。
 * 例如，输入12，1～12这些整数中包含1的数字有1、10、11和12，1一共出现了5次。
 * <p>
 * 示例 1：
 * 输入：n = 12
 * 输出：5
 * <p>
 * 示例 2：
 * 输入：n = 13
 * 输出：6
 * <p>
 * 限制：
 * 1 <= n < 2^31
 */
public class Offer43Solution {
    //动态规划，获得递推公式
    //这个方法还是非常巧，需要想得到才行
    public static int countDigitOne(int n) {
        if (n < 10) return n > 0 ? 1 : 0;
        int digit = 1;
        int totalCount = 0;
        do {
            int highNum = n / (digit * 10);
            int lowNum = n % digit;
            int currentNum = n % (digit * 10) / digit;
            if (digit == 1) {//当前位为个位
                totalCount += currentNum == 0 ? highNum * digit :
                        currentNum == 1 ? (highNum + 1) * digit :
                                currentNum >= 2 ? (highNum + 1) * digit : 0;
            } else if (n / 10 < digit) {//最高位
                totalCount += currentNum == 0 ? 0 :
                        currentNum == 1 ? lowNum + 1 :
                                currentNum >= 2 ? digit : 0;
            } else {
                totalCount += currentNum == 0 ? highNum * digit :
                        currentNum == 1 ? highNum * digit + lowNum + 1 :
                                currentNum >= 2 ? (highNum + 1) * digit : 0;
            }
            if (n / 10 >= digit) digit *= 10;
            else break;
        } while (n >= digit);
        return totalCount;
    }


    public static void main(String[] args) {
        //最终还是有错误，因为使用的整型数超限；
        //可以借鉴字符串的形式处理，可以防止
        int input = 1410065408;
        System.out.print(countDigitOne(input));
    }
}
