package to.geekbang;

import base.struct.tree.TreeNode;
import org.junit.Test;

import java.util.Stack;

public class Lesson23_Tree2 {

    //前序遍历
    public static void preOrderPrint(TreeNode root) {
        if (null == root) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode current = stack.pop();
            if (null != current.right) stack.push(current.right);
            if (null != current.left) stack.push(current.left);
            System.out.print(current.val);
            System.out.print(" , ");
        }
        System.out.println();
    }

    //中序遍历
    public static void inOrderPrint(TreeNode root) {
        if (null == root) return;
        Stack<TreeNode> stack = new Stack<>();
        while (null != root || !stack.empty()) {
            if (null != root) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode current = stack.pop();
                System.out.print(current.val);
                System.out.print(" , ");
                root = current.right;
            }
        }
        System.out.println();
    }

    //后续遍历
    public static void posOrderPrint(TreeNode root) {
        if (null == root) return;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.empty()) {
            TreeNode current = stack1.pop();
            stack2.push(current);
            if (null != current.left) stack1.push(current.left);
            if (null != current.right) stack1.push(current.right);
        }
        while (!stack2.empty()) {
            System.out.print(stack2.pop().val);
            System.out.print(" , ");
        }
        System.out.println();
    }

    public static class UnitTest {

        @Test
        public void testPrint() {
            TreeNode node1 = new TreeNode(10);
            TreeNode node2 = new TreeNode(9);
            TreeNode node3 = new TreeNode(8);
            TreeNode node4 = new TreeNode(7);
            TreeNode node5 = new TreeNode(6);
            TreeNode node6 = new TreeNode(5);
            node6.left = node1;
            TreeNode node7 = new TreeNode(4);
            node7.left = node3;
            node7.right = node2;
            TreeNode node8 = new TreeNode(3);
            node8.left = node5;
            node8.right = node4;
            TreeNode node9 = new TreeNode(2);
            node9.left = node7;
            node9.right = node6;
            TreeNode node10 = new TreeNode(1);
            node10.left = node9;
            node10.right = node8;

            TreeNode root = node10;

            preOrderPrint(root);
            inOrderPrint(root);
            posOrderPrint(root);
        }
    }
}
