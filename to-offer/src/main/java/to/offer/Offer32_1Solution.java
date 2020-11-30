package to.offer;

import base.struct.tree.TreeNode;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/***
 * 剑指 Offer 32 - I. 从上到下打印二叉树
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回：
 * [3,9,20,15,7]
 *  
 * 提示：
 * 节点总数 <= 1000
 */
public class Offer32_1Solution {
    /**
     * 广度优先遍历
     *
     * @param root
     * @return
     */
    public int[] levelOrder(TreeNode root) {
        if(null==root)return new int[0];
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (null != node.left) queue.add(node.left);
            if (null != node.right) queue.add(node.right);
            result.add(node.val);
        }
        int[] nums = new int[result.size()];
        for (int i = 0; i < result.size(); i++) nums[i] = result.get(i);
        return nums;
    }
}
