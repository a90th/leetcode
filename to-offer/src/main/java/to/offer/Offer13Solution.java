package to.offer;

/***
 * 剑指 Offer 13. 机器人的运动范围
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，
 * 因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 * 示例 1：
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 *
 * 示例 2：
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 *
 * 提示：
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 */
public class Offer13Solution {

    public static void main(String[] args) {
        //基础验证
        int result = new Offer13Solution().movingCount2(38, 15, 9);
        System.out.println(result);
    }

    /**
     * 方法1：等同于二维矩阵搜索路径，但是没有"不可重复经过"限制，那就是寻找最大联通的方格数
     * 目标是对最大联通方格计数。
     * 深度优先遍历
     * 迭代条件，当前位置坐标，对方问过的点染色，不重复计数。
     * 访问到当前节点的条件是已经访问到了相邻的节点，保证存在连续性
     *
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCount(int m, int n, int k) {
        int[][] board = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 1;
            }
        }
        return dfs(0, 0, k, board);
    }

    public int dfs(int i, int j, int k, int[][] board) {
        //访问到边界，返回0
        if (i < 0 || j < 0 || i > board.length - 1 || j > board[i].length - 1) return 0;
        //超过限制k，返回0
        if (get(i) + get(j) > k) return 0;
        //已经访问过，返回0
        if (board[i][j] == 0) return 0;
        board[i][j] = 0;
        //可优化为只向下和向右搜索
//        return 1 + dfs(i - 1, j, k, board) + dfs(i + 1, j, k, board) + dfs(i, j - 1, k, board) + dfs(i, j + 1, k, board);
        return 1 + dfs(i + 1, j, k, board) + dfs(i, j + 1, k, board);
    }

    /**
     * 方法2：基于只需向下、向右搜索的事实，可以递推，统计所有可达格子的个数
     *
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCount2(int m, int n, int k) {
        if (0 == m || 0 == n) return 0;
        if (0 == k) return 1;
        boolean[][] board = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = false;
            }
        }
        board[0][0] = true;
        int result = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //初始格子跳过，超限跳过
                if ((i == 0 && j == 0) || (get(i) + get(j) > k)) continue;
                //可从上触达
                if (j - 1 >= 0) {
                    board[i][j] |= board[i][j - 1];
                }
                //可从左触达
                if (i - 1 >= 0) {
                    board[i][j] |= board[i - 1][j];
                }
                if (board[i][j]) result++;
            }
        }
        return result;

    }

    public int get(int x) {
        int res = 0;
        for (; x > 0; x = x / 10) {
            res += x % 10;
        }
        return res;
    }
}
