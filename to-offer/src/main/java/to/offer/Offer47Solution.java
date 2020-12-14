package to.offer;

/**
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 *
 * 示例 1:
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 */
public class Offer47Solution {

    //动态规划解法
    public int maxValue(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int upMax = 0;
                int leftMax = 0;
                if (i > 0) upMax = grid[i - 1][j];
                if (j > 0) leftMax = grid[i][j - 1];
                grid[i][j] = grid[i][j] + (upMax > leftMax ? upMax : leftMax);
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }

    //使用贪心算法可能无法拿到最优解
}
