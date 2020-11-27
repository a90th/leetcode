package to.offer;

import java.util.*;

/***
 * 剑指 Offer 32 - III. 从上到下打印二叉树 III
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *  
 * 提示：
 * 节点总数 <= 1000
 */
public class Offer32_3Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> result = new ArrayList<>();

        if (null != root) queue.add(root);
        boolean oddRow = true;
        do {
            List<Integer> aRow = new ArrayList<>();
            Deque<TreeNode> queueBak = new ArrayDeque<>();
            if (oddRow) {
                while (!queue.isEmpty()) {
                    TreeNode node = queue.poll();
                    if (null != node.left) queueBak.add(node.left);
                    if (null != node.right) queueBak.add(node.right);
                    aRow.add(node.val);
                }
            } else {
                while (!queue.isEmpty()) {
                    TreeNode node = queue.pollLast();
                    if (null != node.right) queueBak.addFirst(node.right);
                    if (null != node.left) queueBak.addFirst(node.left);
                    aRow.add(node.val);
                }
            }
            if (!aRow.isEmpty()) {
                result.add(aRow);
                oddRow = !oddRow;
            }
            queue = queueBak;
        } while (!queue.isEmpty());
        return result;
    }
}
