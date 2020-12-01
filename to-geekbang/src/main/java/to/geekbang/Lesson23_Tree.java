package to.geekbang;

import base.struct.tree.TreeNode;
import org.junit.Test;

public class Lesson23_Tree {

    //前序遍历
    public static void preOrderPrint(TreeNode root) {
        if (null == root) return;
        System.out.print(root.val);
        System.out.print(" , ");
        preOrderPrint(root.left);
        preOrderPrint(root.right);
    }

    //中序遍历
    public static void midOrderPrint(TreeNode root) {
        if(null==root)return;
        midOrderPrint(root.left);
        System.out.print(root.val);
        System.out.print(" , ");
        midOrderPrint(root.right);
    }

    //后序遍历
    public static void posOrderPrint(TreeNode root) {

    }

    //按层遍历
    public static void levelPrint(TreeNode root) {

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

            TreeNode root=node10;

            preOrderPrint(root);
            midOrderPrint(root);
        }
    }

}
