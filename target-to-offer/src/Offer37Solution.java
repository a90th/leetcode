import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 剑指 Offer 37. 序列化二叉树
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 * <p>
 * 示例: 
 * 你可以将以下二叉树：
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * <p>
 * 序列化为 "[1,2,3,null,null,4,5]"
 */
public class Offer37Solution {

    public static void main(String[] args) {
        //基准测试
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        String result = new Offer37Solution().serialize(root);
        System.out.print(result);
    }

    /**
     * 使用广度优先遍历，表达为完全树
     *
     * @param root
     * @return
     */
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder("[");
        if (null == root) {
            builder.append("]");
            return builder.toString();
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int validCount = 1;
        while (!queue.isEmpty() && validCount > 0) {
            TreeNode node = queue.poll();
            validCount--;
            if (!builder.toString().endsWith("[")) builder.append(",");
            if (node.val == -1) {
                builder.append("null");
                queue.add(new TreeNode(-1));
                queue.add(new TreeNode(-1));
            } else {
                builder.append(node.val);
                if (null != node.left) {
                    queue.add(node.left);
                    validCount++;
                } else {
                    queue.add(new TreeNode(-1));
                }

                if (null != node.right) {
                    queue.add(node.right);
                    validCount++;
                } else {
                    queue.add(new TreeNode(-1));
                }
            }
        }
        builder.append("]");
        return builder.toString();
    }

    public TreeNode deserialize(String data) {
        if ("[]".equals(data)) return null;
        //形成二叉堆结构
        String[] strNums = data.substring(1, data.length() - 1).split(",");
        TreeNode[] nodes = new TreeNode[strNums.length];
        for (int i = 0; i < strNums.length; i++) {
            if ("null".equals(strNums[i])) {
                nodes[i] = null;
            } else {
                nodes[i] = new TreeNode(Integer.valueOf(strNums[i]));
            }
        }
        //重建二叉堆
        for (int i = 0; i < nodes.length / 2 + 1; i++) {
            if (null != nodes[i]) {
                if (2 * i + 1 < nodes.length) nodes[i].left = nodes[2 * i + 1];
                if (2 * i + 2 < nodes.length) nodes[i].right = nodes[2 * i + 2];
            }
        }
        return nodes[0];
    }
}
