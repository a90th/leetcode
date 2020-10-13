/***
 * 剑指 Offer 10- II. 青蛙跳台阶问题
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * 示例 1：
 * 输入：n = 2
 * 输出：2
 *
 * 示例 2：
 * 输入：n = 7
 * 输出：21
 *
 * 示例 3：
 * 输入：n = 0
 * 输出：1
 *
 * 提示：
 * 0 <= n <= 100
 */
public class Offer10_2Solution {

    /**
     * 状态转移方程f(n)=f(n-1)+f(n-2);
     *
     * @param n
     * @return
     */
    public int numWays(int n) {
        if (0 == n) return 1;
        if (1 == n) return 1;
        if (2 == n) return 2;
        int n_2 = 1;
        int n_1 = 2;
        int param = 3;
        int result = 3;
        while (param <= n) {
            result = (n_1 % 1000000007 + n_2 % 1000000007) % 1000000007;
            n_2 = n_1;
            n_1 = result;
            param++;
        }
        return result;
    }
}
