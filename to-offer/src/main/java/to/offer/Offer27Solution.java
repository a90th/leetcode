package to.offer;

import base.struct.tree.TreeNode;

/***
 * 剑指 Offer 27. 二叉树的镜像
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 * 例如输入：
 *            4
 *          /  \
 *         2    7
 *       / \   / \
 *      1  3 6    9
 * 镜像输出：
 *
 *            4
 *          /  \
 *         7    2
 *       / \   / \
 *      9  6 3    1
 *
 * 示例 1：
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 *
 * 限制：
 * 0 <= 节点个数 <= 1000
 *
 */
public class Offer27Solution {

    /**
     * 方法1：分治法，递归方式实现
     *
     * @param root
     * @return
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (null == root) return null;
        TreeNode tmp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tmp);
        return root;
    }
}
