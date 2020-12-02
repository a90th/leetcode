package to.geekbang;

import org.junit.Test;

public class Lesson40_DynamicProgram {

    //正则表达式匹配
    //模式串中允许*和?，分别用于匹配任意长度任意字符、单个任意字符
    //动态规划，从子问题逐渐迭代演绎
    public static boolean isMatch(char[] origin, char[] pattern) {
        int OLen = origin.length;
        int PLen = pattern.length;
        boolean[][] matches = new boolean[OLen + 1][PLen + 1];
        for (int i = 0; i <= OLen; i++) {
            for (int j = 0; j <= PLen; j++) {
                if (i == 0 && j == 0) matches[i][j] = true;
                else if ('*' == pattern[0] && j == 0) {
                    matches[i][j] = true;
                } else {
                    matches[i][j] = false;
                }
            }
        }
        for (int oIndex = 0; oIndex < OLen; oIndex++) {
            for (int pIndex = 0; pIndex < PLen; pIndex++) {
                if (('?' == pattern[pIndex] || origin[oIndex] == pattern[pIndex])) {
                    matches[oIndex + 1][pIndex + 1] = matches[oIndex][pIndex];
                }
                if ('*' == pattern[pIndex]) {
                    matches[oIndex + 1][pIndex + 1] = matches[oIndex][pIndex + 1] || matches[oIndex][pIndex];
                }
            }
        }
        return matches[OLen][PLen];
    }


    public static class UnitTest {

        @Test
        public void testStrMatch() {
            String origin = "xiaoming";
            String pattern = "xiao**ng";
            boolean result = isMatch(origin.toCharArray(), pattern.toCharArray());
            System.out.print(result);
        }
    }
}
