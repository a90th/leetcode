package to.offer;

import base.struct.tree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * 剑指 Offer 34. 二叉树中和为某一值的路径
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
 * 从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *  
 * 提示：
 * 节点总数 <= 10000
 */
public class Offer34Solution {

    public static void main(String[] args){
        TreeNode root=new TreeNode(-2);
        root.right=new TreeNode(-3);
        List<List<Integer>> result=new Offer34Solution().pathSum(root,-2);
        System.out.print(result);
    }
    /**
     * 分治递归
     * 不停地创建List，效率很差
     * 对于返回列表之类的函数，不如将数组作为参数，传入函数，地址传递
     *
     * @param root
     * @param sum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> path = new ArrayList<>();
        if (null == root) return path;
        else if (root.val == sum && null == root.left && null == root.right) {
            List<Integer> aRow = Arrays.asList(root.val);
            path.add(aRow);
        } else if (root.val != sum && null == root.left && null == root.right) {
            return path;
        } else {
            if (null != root.left) {
                List<List<Integer>> leftPath = pathSum(root.left, sum - root.val);
                if (null != leftPath && !leftPath.isEmpty()) {
                    leftPath.forEach(aRow -> {
                        List<Integer> bRow = new ArrayList<>();
                        bRow.add(root.val);
                        bRow.addAll(aRow);
                        path.add(bRow);
                    });
                }
            }
            if (null != root.right) {
                List<List<Integer>> rightPath = pathSum(root.right, sum - root.val);
                if (null != rightPath && !rightPath.isEmpty()) {
                    rightPath.forEach(aRow -> {
                        List<Integer> bRow = new ArrayList<>();
                        bRow.add(root.val);
                        bRow.addAll(aRow);
                        path.add(bRow);
                    });
                }
            }
        }
        return path;
    }
}
