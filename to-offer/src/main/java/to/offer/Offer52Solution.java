package to.offer;

import base.struct.list.LinkedNode;

/**
 * 两个链表的第一个公共节点
 */
public class Offer52Solution {

    //巧妙的双指针遍历方法；
    public LinkedNode getIntersectionNode(LinkedNode headA, LinkedNode headB) {
        LinkedNode up = headA;
        LinkedNode down = headB;

        boolean upChanged = false;
        boolean downChanged = false;
        while (up != down) {
            up = up.next;
            down = down.next;
            if (null == up && !upChanged) {
                up = headB;
                upChanged = true;
            } else break;
            if (null == down && !downChanged) {
                down = headA;
                downChanged = true;
            } else break;
        }
        if (up == down) return up;
        else return null;

    }
}
