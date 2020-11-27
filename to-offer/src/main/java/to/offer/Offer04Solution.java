package to.offer;

/***
 * 剑指 Offer 04. 二维数组中的查找
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 示例:
 * 现有矩阵 matrix 如下：
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * 给定 target = 20，返回 false。
 *
 *
 * 限制：
 * 0 <= n <= 1000
 * 0 <= m <= 1000
 */
public class Offer04Solution {

    public static void main(String[] args) {
        //Step1:基础验证
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
//        int[][] matrix = {{-5}};
        boolean result = new Offer04Solution().findNumberIn2DArray2(matrix, 5);
        System.out.println(result);
        result = new Offer04Solution().findNumberIn2DArray2(matrix, 20);
        System.out.println(result);
    }

    /**
     * 方法1：暴力遍历比较
     * <p>
     * 时间复杂度：O(m*n)
     * 空间复杂度0
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray1(int[][] matrix, int target) {
        //需要参数检查
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == target) return true;
            }
        }
        return false;
    }

    public boolean findNumberIn2DArray1a(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = matrix[i].length - 1; j > -1; j--) {
                if (matrix[i][j] == target) return true;
                else if (matrix[i][j] < target) break;
                else continue;
            }
        }
        return false;
    }

    /**
     * 方法2： 对角查找
     * <p>
     * 时间复杂度O(m+n)
     * 空间复杂度0
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int i = 0;
        int j = matrix[i].length - 1;
        while (i < matrix.length && j > -1) {
            int rightUpperNum = matrix[i][j];
            if (target == rightUpperNum) {
                return true;
            } else if (target > rightUpperNum) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

    public boolean findNumberIn2DArray2Error(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int i = 0;
        int j = matrix[i].length - 1;
        //循环条件存在无法跳出，保持i=0；j=-1，无法结束循环
        while (i < matrix.length) {
            while (j > -1) {
                int rightUpperNum = matrix[i][j];
                if (target == rightUpperNum) {
                    return true;
                } else if (target > rightUpperNum) {
                    i++;
                    break;
                } else {
                    j--;
                }
            }
        }
        return false;
    }
}
