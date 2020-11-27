package to.offer;

/***
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 *
 * 参考以下这颗二叉搜索树：
 *      5
 *     / \
 *    2   6
 *   / \
 *  1   3
 * 示例 1：
 * 输入: [1,6,3,2,5]
 * 输出: false
 *
 * 示例 2：
 * 输入: [1,3,2,6,5]
 * 输出: true
 *  
 * 提示：
 * 数组长度 <= 1000
 */
public class Offer33Solution {

    public static void main(String[] args){
        int[] postorder={1,2,5,10,6,9,4,3};
        System.out.print(new Offer33Solution().verifyPostorder(postorder));
    }
    /**
     * 后续遍历结果的队尾就是树的根节点，并且必须有根节点才会有叶子节点
     * 可以使用分治法，递归实现
     *
     * @param postorder
     * @return
     */
    public boolean verifyPostorder(int[] postorder) {
        if (null == postorder || postorder.length == 0) return true;
        return isPostOrder(postorder, 0, postorder.length - 1);
    }

    public boolean isPostOrder(int[] postorder, int start, int end) {
        if (start == end || end - start == 1) return true;
        int mid = end;
        while (mid > start) {
            if (postorder[mid - 1] > postorder[end]) mid--;
            else break;
        }
        if (mid == start) return isPostOrder(postorder, start, end - 1);
        else {
            for (int i = start; i < mid; i++) {
                if (postorder[i] > postorder[end]) return false;
            }
            if(mid == end) return isPostOrder(postorder, start, end - 1);
            return isPostOrder(postorder, start, mid - 1) && isPostOrder(postorder, mid, end - 1);
        }
    }
}
