/***
 * 剑指 Offer 10- I. 斐波那契数列
 *
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 示例 1：
 * 输入：n = 2
 * 输出：1
 * 示例 2：
 *
 * 输入：n = 5
 * 输出：5
 *
 * 提示：
 * 0 <= n <= 100
 *
 * 注意：需要考虑斐波那契数列结果中超出int、long类型范围的数字
 */
public class Offer10Solution {
    private long computCount = 0;

    public static void main(String[] args) {
        //基础验证
        Offer10Solution solution = new Offer10Solution();
        assert 1 == solution.fib1(2);
        System.out.println(solution.computCount);

        Offer10Solution solution1 = new Offer10Solution();
        assert 5 == solution1.fib1(5);
        System.out.println(solution1.computCount);

        Offer10Solution solution3 = new Offer10Solution();
        long a3 = solution3.fib3(95);
        System.out.println(a3);
        System.out.println(solution3.computCount);

    }

    /**
     * 方法1：使用递归方法实现
     * 时间复杂度：O(2^N)
     *
     * @param n
     * @return
     */
    public int fib1(int n) {
        computCount++;
        if (0 == n) {
            return 0;
        }
        if (1 == n) {
            return 1;
        }
        return fib1(n - 1) + fib1(n - 2);
    }

    /**
     * 方法2：从小到大计算，存储计算结果
     *
     * @param n
     * @return
     */
    public int fib2(int n) {
        if (0 == n) {
            return 0;
        }
        if (1 == n) {
            return 1;
        }
        int[] result = new int[n + 1];
        result[0] = 0;
        result[1] = 1;
        for (int i = 2; i < result.length; i++) {
            result[i] = (result[i - 1] % 1000000007 + result[i - 2] % 1000000007) % 1000000007;
        }
        return result[n];
    }

    /**
     * 方法3：仅仅暂存最接近的两个
     *
     * @param n
     * @return
     */
    public int fib3(int n) {
        if (0 == n) return 0;
        if (1 == n) return 1;
        int n_1 = 1;
        int n_2 = 0;
        int point = 2;
        int result = 1;
        while (point <= n) {
            result = (n_1 % 1000000007 + n_2 % 1000000007) % 1000000007;
            n_2 = n_1;
            n_1 = result;
            point++;
        }
        return result;
    }
}
