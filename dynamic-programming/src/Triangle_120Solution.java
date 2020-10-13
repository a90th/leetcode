import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * 120. 三角形最小路径和
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * 例如，给定三角形：
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 * 说明：
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 */
public class Triangle_120Solution {

    public static void main(String[] args) {
        //基础验证
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));

        int result = new Triangle_120Solution().minimumTotal2(triangle);
        System.out.println(result);
    }

    /**
     * 方法1：动态规划方法
     *
     * @param triangle
     * @return
     */
    public int minimumTotal1(List<List<Integer>> triangle) {
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int num_ij = triangle.get(i).get(j);
                if (j > 0 && j < i) {
                    num_ij += Math.min(triangle.get(i - 1).get(j), triangle.get(i - 1).get(j - 1));
                    triangle.get(i).set(j, num_ij);
                } else if (j == 0) {
                    num_ij += triangle.get(i - 1).get(j);
                    triangle.get(i).set(j, num_ij);
                } else if (j == i) {
                    num_ij += triangle.get(i - 1).get(j - 1);
                    triangle.get(i).set(j, num_ij);
                }
            }
        }
        int lastRow = triangle.size() - 1;
        int min = triangle.get(lastRow).get(0);
        for (int j = 0; j < triangle.get(lastRow).size(); j++) {
            if (min > triangle.get(lastRow).get(j))
                min = triangle.get(lastRow).get(j);
        }
        return min;
    }

    /**
     * 方法2：动态规划+空间优化
     * 空间复杂度优化至O(n)
     *
     * 1.双数组交替用作计算结果存储
     * 2.单数组存储结果，须从后往前计算
     *
     * @param triangle
     * @return
     */
    public int minimumTotal2(List<List<Integer>> triangle) {
        int[] router = new int[triangle.size()];
        router[0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            router[i] = router[i - 1] + triangle.get(i).get(i);
            for (int k = i - 1; k > 0; k--) {
                router[k] = Math.min(router[k], router[k - 1]) + triangle.get(i).get(k);
            }
            router[0] = router[0] + triangle.get(i).get(0);
        }
        int minNum = router[0];
        for (int i = 0; i < router.length; i++) {
            minNum = Math.min(minNum, router[i]);
        }
        return minNum;
    }

    /****************************
     * 三角形矩阵，数据上具有以下特点：
     * triangle[][]
     * triangle[i].length=i+1;
     *
     * 最短路径状态转移方程
     * f[i][j]=min(f[i-1][j]+triangle[i][j],f[i-1][j-1]+triangle[i][j])
     */
}
