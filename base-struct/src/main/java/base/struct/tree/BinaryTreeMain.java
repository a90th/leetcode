package base.struct.tree;

import java.util.Stack;

/***
 * 二叉树的定义、遍历
 */
public class BinaryTreeMain {

    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.left.left=new TreeNode(3);
        root.left.right=new TreeNode(4);

        root.right=new TreeNode(5);
        root.right.left=new TreeNode(6);

        new BinaryTreeMain().preOrder1(root);


    }

    /**
     * 前序遍历-递归方法
     *
     * @param tree
     * @return
     */
    public void preOrder1(TreeNode tree) {
        if (null == tree) return;
        System.out.print(tree);
        preOrder1(tree.left);
        preOrder1(tree.right);
    }

    /**
     * 前序遍历-非递归方法
     *
     * @param tree
     * @return
     */
    public void preOrder2(TreeNode tree) {
        Stack<TreeNode> stack = new Stack<>();
        while (null != tree || !stack.isEmpty()) {
            while (tree != null) {
                stack.push(tree);
                tree = tree.left;
            }
            if (!stack.isEmpty()) {
                tree = stack.pop();
                System.out.print(tree);
                tree = tree.right;
            }
        }

    }
}
