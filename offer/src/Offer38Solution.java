import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/***
 * 剑指 Offer 38. 字符串的排列
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *
 * 示例:
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 *
 * 限制：
 * 1 <= s 的长度 <= 8
 */
public class Offer38Solution {

    public static void main(String[] args) {
        //基准测试
        String tStr = "abc";
        String[] result = new Offer38Solution().permutation(tStr);
        System.out.print(result.length);
    }

    /**
     * 方法1：递归算法
     *
     * @param s
     * @return
     */
    public String[] permutation(String s) {
        if (null == s || s.length() == 0) return new String[0];
        if (s.length() == 1) return new String[]{s};
        else {
            String firstChar = s.substring(0, 1);
            String[] subResult = permutation(s.substring(1));
            Set<String> existStr = new HashSet<>();
            for (int i = 0; i < subResult.length; i++) {
                for (int j = 0; j < subResult[i].length() + 1; j++) {
                    String str = subResult[i].substring(0, j) + firstChar + subResult[i].substring(j);
                    existStr.add(str);
                }
            }
            String[] result = new String[existStr.size()];
            existStr.toArray(result);
            return result;
        }
    }


}
