import java.rmi.AlreadyBoundException;

/***
 * 剑指 Offer 29. 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 *
 * 示例 2：
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * 限制：
 * 0 <= matrix.length <= 100
 * 0 <= matrix[i].length <= 100
 */
public class Offer29Solution {
    /**
     * 方法1：模拟实现遍历路径
     *
     * @param matrix
     * @return
     */
    public int[] spiralOrder(int[][] matrix) {
        if (null == matrix || matrix.length == 0 || matrix[0].length == 0) return new int[]{};
        Direct direct = Direct.RIGHT;
        boolean[][] alreadyRead = new boolean[matrix.length][matrix[0].length];
        int M = matrix.length;
        int N = matrix[0].length;
        int i = 0, j = -1;

        int[] result = new int[M * N];
        int index = 0;
        do {
            switch (direct) {
                case RIGHT:
                    if (j < N - 1 && !alreadyRead[i][j + 1]) {
                        result[index++] = matrix[i][++j];
                        //这里应该是++j而不是j++，因为检查了下一个格子的数值，应该操作相同格子的数值
                        alreadyRead[i][j] = true;
                    } else if (i < M - 1 && !alreadyRead[i + 1][j]) {
                        result[index++] = matrix[++i][j];
                        alreadyRead[i][j] = true;
                        direct = Direct.DOWN;
                    }
                    break;
                case DOWN:
                    if (i < M - 1 && !alreadyRead[i + 1][j]) {
                        result[index++] = matrix[++i][j];
                        alreadyRead[i][j] = true;
                    } else if (j > 0 && !alreadyRead[i][j - 1]) {
                        result[index++] = matrix[i][--j];
                        alreadyRead[i][j] = true;
                        direct = Direct.LEFT;
                    }
                    break;
                case LEFT:
                    if (j > 0 && !alreadyRead[i][j - 1]) {
                        result[index++] = matrix[i][--j];
                        alreadyRead[i][j] = true;
                    } else if (i > 0 && !alreadyRead[i - 1][j]) {
                        result[index++] = matrix[--i][j];
                        alreadyRead[i][j] = true;
                        direct = Direct.UP;
                    }
                    break;
                case UP:
                    if (i > 0 && !alreadyRead[i - 1][j]) {
                        result[index++] = matrix[--i][j];
                        alreadyRead[i][j] = true;
                    } else if (j < M - 1 && !alreadyRead[i][j + 1]) {
                        result[index++] = matrix[i][++j];
                        alreadyRead[i][j] = true;
                        direct = Direct.RIGHT;
                    }
                    break;
            }
        } while (index < result.length);
        return result;
    }

    enum Direct {
        RIGHT,
        DOWN,
        LEFT,
        UP
    }


    /**
     * 方法2：按层模拟，从外层到中心
     * 不是自己写的
     *
     * @param matrix
     * @return
     */
    public int[] spiralOrder2(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int rows = matrix.length, columns = matrix[0].length;
        int[] order = new int[rows * columns];
        int index = 0;
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
        while (left <= right && top <= bottom) {
            for (int column = left; column <= right; column++) {
                order[index++] = matrix[top][column];
            }
            for (int row = top + 1; row <= bottom; row++) {
                order[index++] = matrix[row][right];
            }
            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--) {
                    order[index++] = matrix[bottom][column];
                }
                for (int row = bottom; row > top; row--) {
                    order[index++] = matrix[row][left];
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return order;
    }
}
