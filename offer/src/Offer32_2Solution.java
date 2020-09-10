import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/***
 * 剑指 Offer 32 - II. 从上到下打印二叉树 II
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *  
 *
 * 提示：
 * 节点总数 <= 1000
 */
public class Offer32_2Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(null==root)return new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> result = new ArrayList<>();

        queue.add(root);
        do {
            List<Integer> aRow = new ArrayList<>();
            Queue<TreeNode> queueBak = new ArrayDeque<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (null != node.left) queueBak.add(node.left);
                if (null != node.right) queueBak.add(node.right);
                aRow.add(node.val);
            }
            if (!aRow.isEmpty()) result.add(aRow);
            queue = queueBak;
        } while (!queue.isEmpty());
        return result;
    }
}
