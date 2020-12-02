package to.geekbang;

import org.junit.Test;

public class Lesson39_BackTrack {

    public static void eightPrince() {

    }

    //正则表达式匹配
    //模式串中允许*和?，分别用于匹配任意长度任意字符、单个任意字符
    //回溯方法，适合使用递归实现
    public static boolean isMatch(char[] origin, char[] pattern) {
        return recurIsMatch(origin, 0, pattern, 0);
    }

    public static boolean recurIsMatch(char[] origin, int oStart, char[] pattern, int pStart) {
        if (oStart == origin.length && pStart == pattern.length) return true;
        if ('*' == pattern[pStart]) {
            for (int i = oStart + 1; i < origin.length; i++) {
                if (recurIsMatch(origin, i, pattern, pStart + 1)) {
                    return true;
                }
            }
        } else if ('?' == pattern[pStart] || pattern[pStart] == origin[oStart]) {
            return recurIsMatch(origin, oStart + 1, pattern, pStart + 1);
        }
        return false;
    }

    public static class UnitTest {


        @Test
        public void testStrMatch() {
            String origin = "xiaong";
            String pattern = "xiao*ing";
            boolean result = isMatch(origin.toCharArray(), pattern.toCharArray());
            System.out.print(result);
        }
    }
}
