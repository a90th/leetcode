package to.offer;

import java.lang.Math;

/***
 * 剑指 Offer 14- I. 剪绳子
 *
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1）
 * 每段绳子的长度记为 k[0],k[1]...k[m-1] 。
 * 请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
 *
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 示例 1：
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 *
 * 示例2:
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 ×3 ×4 = 36
 *
 * 提示：
 * 2 <= n <= 58
 *
 */
public class Offer14Solution {

    public static void main(String[] args) {
        //基准测试
        int result = new Offer14Solution().cuttingRope2(5);
        System.out.println(result);
    }

    /**
     * 使用递归的方式解决
     * 需要注意的是由于要求m>1，所以n=2时result=1；但是作为后续计算基础的时候n=2可以作为一段那么result=2
     *
     * @param n
     * @return
     */
    public int cuttingRope(int n) {
        if (2 == n) return 1;
        if (3 == n) return 2;
        int[] result = new int[n + 1];
        result[1] = 1;
        result[2] = 2;
        result[3] = 3;
        for (int i = 4; i < n + 1; i++) {
            int max = 1;
            for (int j = 1; j <= i / 2 + 1; j++) {
                int tmp = result[j] * result[i - j];
                if (tmp > max) {
                    max = tmp;
                }
            }
            result[i] = max;
        }
        return result[n];
    }

    /**
     * 使用公式推导可以得出每段长度为e时，乘积最大
     * 3是最接近e的整数，应该尽量切成长度为3的段，剩余部分如果为1，那么3+1=2+2；如果剩余为2，则直接相乘
     *
     * @param n
     * @return
     */
    public int cuttingRope2(int n) {
        if (0 == n) return 0;
        if (1 == n) return 0;
        if (2 == n) return 1;
        if (3 == n) return 2;
        if (n > 3) {
            if (n % 3 == 0) {
                return (int) Math.pow(3, n / 3);
            } else if (n % 3 == 2) {
                return (int) Math.pow(3, n / 3) * 2;
            } else {
                return (int) Math.pow(3, n / 3 - 1) * 4;
            }
        }
        return 0;
    }
}
