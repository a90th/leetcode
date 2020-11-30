package to.offer;

import base.struct.graph.RandomNode;

import java.util.HashMap;
import java.util.Map;

/***
 * 剑指 Offer 35. 复杂链表的复制
 * 请实现 copyRandomList 函数，复制一个复杂链表。
 * 在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 * 示例 1：
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 *
 * 示例 2：
 * 输入：head = [[1,1],[2,1]]
 * 输出：[[1,1],[2,1]]
 *
 * 示例 3：
 * 输入：head = [[3,null],[3,0],[3,null]]
 * 输出：[[3,null],[3,0],[3,null]]
 *
 * 示例 4：
 * 输入：head = []
 * 输出：[]
 * 解释：给定的链表为空（空指针），因此返回 null。
 *  
 *
 * 提示：
 * -10000 <= RandomNode.val <= 10000
 * RandomNode.random 为空（null）或指向链表中的节点。
 * 节点数目不超过 1000 。
 */
public class Offer35Solution {

    /**
     * 复杂链表的复制，难点在于节点不仅仅有next引用，还有一个random随机引用
     * 链表的节点的创建顺序与引用顺序不相符
     *
     * @param head
     * @return
     */
    public RandomNode copyRandomList(RandomNode head) {
        if (null == head) return null;
        Map<RandomNode, RandomNode> oldToNew = new HashMap<>();
        RandomNode copy = new RandomNode(head.val);
        oldToNew.put(head, copy);
        RandomNode preHead = new RandomNode(-1);
        preHead.next = copy;
        while (null != head) {
            if (null != head.next && null == oldToNew.get(head.next)) {
                RandomNode RandomNode = new RandomNode(head.next.val);
                oldToNew.put(head.next, RandomNode);
            }
            if (null != head.random && null == oldToNew.get(head.random)) {
                RandomNode RandomNode = new RandomNode(head.random.val);
                oldToNew.put(head.random, RandomNode);
            }
            copy.next = oldToNew.get(head.next);
            copy.random = oldToNew.get(head.random);
            copy = copy.next;
            head = head.next;
        }
        return preHead.next;
    }
}
