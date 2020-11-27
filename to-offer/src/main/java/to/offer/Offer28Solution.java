package to.offer;

import java.util.*;

/***
 * 剑指 Offer 28. 对称的二叉树
 *
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。
 * 如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 * 例如，二叉树[1,2,2,3,4,4,3] 是对称的。
 *           1
 *          / \
 *         2   2
 *       / \  / \
 *      3  4 4  3
 * 但是下面这个[1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *           1
 *         / \
 *       2    2
 *       \    \
 *        3    3
 *
 * 示例 1：
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * 示例 2：
 *
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 *
 * 限制：
 * 0 <= 节点个数 <= 1000
 */
public class Offer28Solution {
    /**
     * 方法1：分治法
     * 重点：搞明白"对称是双目运算，不是单目运算"，递推的逻辑是"判断root是左右对称的，需要root.left.value=root.right.value，
     * 并且root.left.left与root.right.right对称，root.left.right与root.right.left对称"
     *
     * 不能使用广度优先遍历，因为存在一种遍历结果对应多种属结构的情况
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (null == root) return true;
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode A, TreeNode B) {
        if (null != A && null != B) {
            return A.val == B.val && isSymmetric(A.left, B.right) && isSymmetric(A.right, B.left);
        } else {
            return null == A && null == B;
        }
    }
}
