import java.util.ArrayDeque;
import java.util.Queue;

/***
 * 剑指 Offer 26. 树的子结构
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 * 例如:
 * 给定的树 A:
 *
 *            3
 *           / \
 *          4   5
 *         / \
 *        1   2
 * 给定的树 B：
 *
 *       4
 *      /
 *     1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 *
 * 示例 1：
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 *
 * 示例 2：
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 * 限制：
 *
 * 0 <= 节点个数 <= 10000
 */
public class Offer26Solution {

    public static void main(String[] args) {
        //基准测试
//        [10,12,6,8,3,11][10,12,6,8]

    }

    /**
     * 方法1：深度、广度优先遍历，逐个进行匹配
     *
     * @param A
     * @param B
     * @return
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (null == A || null == B) return false;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(A);
        while (!queue.isEmpty()) {
            TreeNode current = queue.remove();
            if (isSame(current, B)) return true;
            if (null != current.left) queue.add(current.left);
            if (null != current.right) queue.add(current.right);
        }
        return false;
    }

    public boolean isSame(TreeNode A, TreeNode B) {
        if (null == A) return null == B;
        if (null == B) return null == A;
        return A.val == B.val && isSame(A.left, B.left) && isSame(A.right, B.right);
    }
}
