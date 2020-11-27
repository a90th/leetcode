package to.offer;

/***
 * 剑指 Offer 15. 二进制中1的个数
 * 请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。
 * 例如，把 9表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
 *
 * 示例 1：
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011中，共有三位为 '1'。
 *
 * 示例 2：
 * 输入：00000000000000000000000010000000
 * 输出：1
 * 解释：输入的二进制串 00000000000000000000000010000000中，共有一位为 '1'。
 *
 * 示例 3：
 * 输入：11111111111111111111111111111101
 * 输出：31
 * 解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
 */
public class Offer15Solution {

    public static void main(String[] args) {
        int n = 0b11111111111111111111111111111101;
        System.out.println(n);
        int result = new Offer15Solution().hammingWeight2(n);
        System.out.println(result);
    }

    /**
     * n视为无符号数
     * 使用短除法
     *
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int result = 0;
        while (n != 0) {//这里使用不等于0而不是大于0，考虑有符号数小于0的情况
            result += n & 1;//与1位与不考虑符号位的影响，使用%2求余则会受符号位的影响
            n = n >>> 1;//这里是无符号右移
        }
        return result;
    }

    /**
     * 方法2：使用 n&(n-1)每次消除n中最后一位的1
     *
     * @param n
     * @return
     */
    public int hammingWeight2(int n) {
        int result = 0;
        while (n != 0) {
            result += 1;
            n = n & (n - 1);
        }
        return result;
    }
}
