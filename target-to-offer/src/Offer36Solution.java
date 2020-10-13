import java.util.ArrayList;
import java.util.List;

/***
 * 剑指 Offer 36. 二叉搜索树与双向链表
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 *
 * 为了让您更好地理解问题，以下面的二叉搜索树为例：
 *
 * 我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。
 * 对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。
 *
 * 下图展示了上面的二叉搜索树转化成的链表。“head” 表示指向链表中有最小元素的节点。
 *
 * 特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。
 */
public class Offer36Solution {

    public static void main(String[] args) {
        //基准测试
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(3);

        Node result = new Offer36Solution().treeToDoublyList(root);
        System.out.print(result);
    }

    /**
     * 中序遍历即可拿到正确排序的列表
     *
     * @param root
     * @return
     */
    public Node treeToDoublyList(Node root) {
        if (null == root) return null;
        List<Node> list = inorder(root);
        int length = list.size();
        for (int i = 0; i < list.size(); i++) {
            list.get(i % length).right = list.get((i + 1) % length);
            list.get((i + 1) % length).left = list.get(i % length);
        }
        return list.get(0);
    }

    public List<Node> inorder(Node node) {
        if (null == node) return null;
        List<Node> result = new ArrayList<>();

        if (null != node.left) result.addAll(inorder(node.left));
        result.add(node);
        if (null != node.right) result.addAll(inorder(node.right));

        return result;
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}

