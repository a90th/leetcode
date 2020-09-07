/***
 * 剑指 Offer 19. 正则表达式匹配
 * 请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
 * 而'*'表示它前面的字符可以出现任意次（含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
 *
 * 示例 1:
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 *
 * 示例 2:
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释:因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 *
 * 示例3:
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释:".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 *
 * 示例 4:
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释:因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 *
 * 示例 5:
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 * s可能为空，且只包含从a-z的小写字母。
 * p可能为空，且只包含从a-z的小写字母以及字符.和*，无连续的 '*'。
 */
public class Offer19Solution {

    public static void main(String[] args) {
        //基准验证
//        boolean result = new Offer19Solution().isMatch1("aab", "c*a*b");
        boolean result = new Offer19Solution().isMatch1("mississippi", "mis*is*p*.");
        System.out.println(result);
    }

    /**
     * 方法1：动态规划方法
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch1(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = false;
            }
        }
        //s的空子串与p的空子串匹配
        dp[0][0] = true;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if ('.' == p.charAt(j - 1) || p.charAt(j - 1) == s.charAt(i - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                if ('*' == p.charAt(j - 1) && '.' == p.charAt(j - 2)) {
                    for (int k = 1; k < i; k++) {
                        dp[k][j] = dp[k][j - 2] || dp[k][j];
                        dp[k][j - 1] = dp[k - 1][j - 2] || dp[k][j - 1];
                    }
                    dp[i][j] = dp[i - 1][j - 1];
                    dp[i][j - 1] = dp[i - 1][j - 2] || dp[i][j - 1];
                } else if ('*' == p.charAt(j - 1)) {
                    for (int k = 1; k < i - 1; k++) {
                        dp[k][j] = dp[k][j - 2] || dp[k][j];
                        dp[k][j - 1] = dp[k - 1][j - 2] || dp[k][j - 1];
                    }
                    if (i >= 2) {
                        dp[i - 1][j] = (dp[i - 2][j - 2] && (s.charAt(i - 2) == p.charAt(j - 2))) || dp[i - 1][j];
                    } else {
                        dp[i - 1][j] = dp[i - 1][j - 2] || dp[i - 1][j];
                    }
                    dp[i][j] = (dp[i - 1][j] && (s.charAt(i - 1) == p.charAt(j - 2))) || dp[i][j];
                    dp[i][j - 1] = (dp[i - 1][j - 2] && (s.charAt(i - 1) == p.charAt(j - 2))) || dp[i][j - 1];
                }
                printVector(dp);
            }
        }
        return dp[s.length()][p.length()];
    }

    public void printVector(boolean[][] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                System.out.print(nums[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}
