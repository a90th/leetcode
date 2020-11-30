package to.geekbang;

import base.struct.list.LinkedNode;
import org.junit.Test;

/**
 * 回文字符串
 */
public class Lesson06_Palindrome {

    //使用递归方式检查字符串及其子串
    public static boolean isPalindrome(String s) {
        if (null == s) return false;
        if (s.length() <= 1) return true;
        if (s.charAt(0) != s.charAt(s.length() - 1)) {
            return false;
        } else {
            return isPalindrome(s.substring(1, s.length() - 1));
        }
    }

    //优化递归方式中调用深度、字符串碎片问题
    //字符串可以随机访问的
    public static boolean isPalindrome2(String s) {
        if (null == s) return false;
        if (s.length() <= 1) return true;
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            else {
                start++;
                end--;
            }
            if (start >= end) return true;
        }
        return false;
    }

    //查找最长回文子串
    //子串一定是连续的下标，所以可以检查所有的子串(重点是要覆盖所有的子串)
    public static String longestPalindrome1(String s) {
        if (null == s) return "";
        if (isPalindrome2(s)) return s;
        String longest = "";
        int length = s.length();
        for (int i = 0; i < length - 1; i++) {
            for (int j = length - 1; j >= i; j--) {
                String sub = s.substring(i, j + 1);
                if (isPalindrome2(sub) && longest.length() < sub.length()) {
                    longest = sub;
                }
            }
        }
        return longest;
    }

    //经典做法是"快慢指针"，快指针以两倍于慢指针速度移动到链表末尾，慢指针用于定位链表的中间位置
    //慢指针遍历过程中将链表反向
    //第三个步骤是，分别向两边遍历链表
    public static boolean isPalindrome3(LinkedNode head) {
        if (null == head || null == head.next) return true;
        LinkedNode pre = null;
        LinkedNode slow = head;
        LinkedNode fast = head;
        //向后移动，快指针遍历链表
        while (null != fast && null != fast.next) {
            LinkedNode tmp = slow;
            slow = slow.next;
            fast = fast.next.next;
            //慢指针反转
            tmp.next = pre;
            pre = tmp;
        }
        //分链表节点数奇偶分别处理
        if (null == fast) {//偶数个节点，pre前面链表与slow后面节点个数相同
            //NOP
        } else {//奇数个节点，pre前面链表叫slow后少一个节点
            slow = slow.next;
        }

        while (null != pre) {
            if (null == slow || pre.val != slow.val) return false;
            pre = pre.next;
            slow = slow.next;
        }
        return true;
    }

    public static class UnitTests {

        @Test
        public void testIsPalindrome() {
            String s1 = "";
            String s2 = "a";
            String s3 = "ab";
            String s4 = "aba";
            String s5 = "12345654321";

            assert isPalindrome(s1);
            assert isPalindrome(s2);
            assert !isPalindrome(s3);
            assert isPalindrome(s4);
            assert isPalindrome(s5);
        }

        @Test
        public void testIsPalindrome2() {
            String s1 = "";
            String s2 = "a";
            String s3 = "ab";
            String s4 = "aba";
            String s5 = "12345654321";

            assert isPalindrome2(s1);
            assert isPalindrome2(s2);
            assert !isPalindrome2(s3);
            assert isPalindrome2(s4);
            assert isPalindrome2(s5);
        }

        @Test
        public void testLongestPalindrome() {
            String s1 = "ab";
            String s2 = "12435654321";
            String s3 = "abcdefg";
            assert "a".equals(longestPalindrome1(s1));
            assert "565".equals(longestPalindrome1(s2));
            assert "a".equals(longestPalindrome1(s3));
        }

        @Test
        public void testLinkedListPalindrome() {
            LinkedNode node1 = new LinkedNode(1, null);
            LinkedNode node2 = new LinkedNode(2, node1);
            LinkedNode node3 = new LinkedNode(3, node2);
            LinkedNode node4 = new LinkedNode(2, node3);
            LinkedNode node5 = new LinkedNode(1, node4);

            LinkedNode head = node2;

            assert !isPalindrome3(head);
        }
    }
}
