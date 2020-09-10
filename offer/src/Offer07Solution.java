import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

/***
 * 剑指 Offer 07. 重建二叉树
 *
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 * 例如，给出
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 *
 * 返回如下的二叉树：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 限制：
 * 0 <= 节点个数 <= 5000
 */
public class Offer07Solution {

    public static void main(String[] args) {
        //基础验证
//        int[] preorder = {3, 9, 20, 15, 7};
//        int[] inorder = {9, 3, 15, 20, 7};
        int[] preorder = {-77, 24, -74, 84, 93, 28, 83, 6, 95, 58, 59, 66, 22, -3, -66, -68, -22, 3, -80, -79, -85, 17, 32, 9, -88, -99, 14, -60, 13, -93, -63, 91, 82, 21, 26, -11, -32, -16, -100, -94, -31, -62, -89, 49, -9, -8, 87, -33, -81, 80, 0, 69, -7, 52, 67, -5, -65, 31, -30, 37, -57, 27, 23, 38, -28, 7, -82, -42, 11, -55, -36, -58, -24, 89, 56, 73, 41, 18, -87, -70, 4, -64, 20, -52, -39, 79, 19, 30, 65, 25, -71, -76, -1, 62, -69, 98, 39, -25, -73, 70, 88, -17, -20, -75, 55, 34, 57, 81, -10, 94, 48, -35, 5, -23, -44, 40, -51, -61, -13, -86, 63, 71, -97, 45, 43, 51, 75, 33, -34, 92, 47, -78, 85, -26, 97, -29, -92, -83, -59, 74, 96, 68, 77, 16, -4, 10, 60, 64, -21, -2, 1, -91, 86, 46, 76, -37, -19, -96, 36, -98, 29, -72, 61, 50, 15, -95, -40, -43, -53, 90, -15, -48, -27, -90, -54, 72, -50, -49, -18, 78, 54, 35, -38, 99, 44, -67, 53, -12, -41, 2, 8, -14, -84, -56, -6, 12, -45, 42, -47, -46};
        int[] inorder = {93, 28, 84, 83, -74, 59, 58, 66, -66, -3, -79, -80, 3, -22, -68, 22, -85, -99, 14, -88, 9, 32, 17, -60, 95, -93, 82, 21, 91, -63, 26, 13, -16, -32, -11, -100, 6, -62, 49, -89, -31, 87, -8, 69, 0, 80, -7, -81, -65, -5, 67, -30, 31, 52, -33, 37, -57, -9, 7, -28, -42, -82, 38, -55, 11, 23, -36, 27, 56, 89, 73, -24, 41, -58, -70, -87, 20, -64, -52, 4, 18, -94, 19, 30, -76, -1, -71, 62, -69, 25, -73, -25, 70, 39, 88, 98, -20, -17, 65, 55, -75, 79, 34, -39, 48, 94, -23, 5, -44, -35, 40, -10, -61, -51, -13, 81, 63, -97, 71, -86, 57, 45, 24, -34, 85, 97, -26, -78, -83, -92, 74, -59, 96, -29, 68, 47, 77, 92, 10, -4, 16, 60, 33, -21, 1, 86, 76, 46, -37, -91, -2, 64, 75, 51, -19, -96, 43, -98, 29, 61, -72, 50, 36, -95, -40, -43, 15, 90, -15, -53, -77, -54, -90, -49, -50, 72, -27, 35, 54, -38, 78, -67, 44, 53, 99, -41, -12, -18, 8, 2, -48, -56, -84, -14, -45, 12, 42, -6, -46, -47};
        TreeNode root = new Offer07Solution().buildTree1(preorder, inorder);
        new Offer07Solution().printTree(root);
    }

    /**
     * 方法1：使用递归方法，每一步骤得出结论后创建新的数组存储需要的子数组,从顶向下
     * 时间复杂度：O(NlogN)
     * 空间耗用：O(NlogN)
     * !!!对于深度比较大的树，出现了超时现象，问题出在哪里？root.right = buildTree1(rightTreePreOrder, rightTreeInorder);位置放错了
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        System.out.println(preorder.length);
        if (preorder.length == 0) {
            return null;
        }
        if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }
        TreeNode root = new TreeNode(preorder[0]);
        boolean isRootInInorder = false;
        int rootIndexInorder = 0;
        for (; rootIndexInorder < inorder.length; rootIndexInorder++) {
            if (root.val == inorder[rootIndexInorder]) {
                isRootInInorder = true;
                break;
            }
        }
        if (isRootInInorder) {
            if (rootIndexInorder > 0) {//存在左树
                int[] leftTreePreorder = new int[rootIndexInorder];
                int[] leftTreeInorder = new int[rootIndexInorder];
                for (int j = 0; j < rootIndexInorder; j++) {
                    leftTreePreorder[j] = preorder[j + 1];
                    leftTreeInorder[j] = inorder[j];
                }
                root.left = buildTree1(leftTreePreorder, leftTreeInorder);
            }
            if (rootIndexInorder < inorder.length - 1) {//存在右树
                int[] rightTreePreOrder = new int[inorder.length - rootIndexInorder - 1];
                int[] rightTreeInorder = new int[inorder.length - rootIndexInorder - 1];
                for (int j = 0; j < inorder.length - 1 - rootIndexInorder; j++) {
                    rightTreePreOrder[j] = preorder[rootIndexInorder + 1 + j];
                    rightTreeInorder[j] = inorder[rootIndexInorder + 1 + j];
                }
                root.right = buildTree1(rightTreePreOrder, rightTreeInorder);
            }
        }
        return root;
    }

    /**
     * 方法2：使用递归，在方法1基础上做以下优化：
     * 1. 将inorder中value和index做键值对存储，省去对inorder的查找
     * 2. 不复制到新的数组，使用数组的index确定数组的开始结束
     * 时间复杂度：
     * 空间耗用：0
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        //检验数组的长度
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        //生成inorder的value和index键值对存储
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        TreeNode root = buildTree2(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, indexMap);
        return root;
    }

    public TreeNode buildTree2(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> indexMap) {
        //首先确认根节点
        if (preStart > preEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        if (preStart == preEnd) {
            return root;
        } else {
            int rootIndex = indexMap.get(root.val);
            int leftNodeCount = rootIndex - inStart;
            int rightNodeCount = inEnd - rootIndex;
            TreeNode subLeftTree = buildTree2(preorder, preStart + 1, preStart + leftNodeCount,
                    inorder, inStart, inStart + leftNodeCount - 1, indexMap);
            //等价TreeNode subRightTree = buildTree2(preorder, preEnd - rightNodeCount + 1, preEnd,inorder, rootIndex + 1, inEnd, indexMap);
            TreeNode subRightTree = buildTree2(preorder, preStart + 1 + leftNodeCount, preEnd,
                    inorder, rootIndex + 1, inEnd, indexMap);
            root.left = subLeftTree;
            root.right = subRightTree;
            return root;
        }
    }

    /**
     * 方法3：官方解法，迭代
     * 时间复杂度：
     * 空间耗用：
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree3(int[] preorder, int[] inorder) {
        if (null == preorder || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }

    /**
     * 打印一个二叉树，从顶向下分层遍历（广度优先遍历）
     * 使用FIFO队列，每次根节点出队列时分别把左节点和右节点入队列
     *
     * @param root
     */
    public void printTree(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        for (; !queue.isEmpty(); ) {
            TreeNode currentNode = queue.poll();
            if (null != currentNode.left) queue.add(currentNode.left);
            if (null != currentNode.right) queue.add(currentNode.right);
            System.out.print(currentNode.val + "\t");
        }
    }
}


