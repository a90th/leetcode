package to.offer;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class Offer48Solution {

    public static void main(String[] args) {
        String input = "pwwkew";
        System.out.println(longestSubStr(input));
        System.out.println(lengthOfLongestSubStr(input));
    }


    public static String longestSubStr(String origin) {
        if (null == origin || origin.length() == 0) return "";
        String longestStr = "";
        String currentStr = "";
        HashSet<Character> aSet = new HashSet<>();
        for (int i = 0; i < origin.length(); i++) {
            char current = origin.charAt(i);
            if (aSet.contains(current)) {
                int index = currentStr.indexOf(current);
                for (int j = 0; j <= index; j++) {
                    aSet.remove(currentStr.charAt(j));
                }
                currentStr = currentStr.substring(index + 1);
            }
            aSet.add(current);
            currentStr += current;
            if (currentStr.length() > longestStr.length()) {
                longestStr = currentStr;
            }
        }
        return longestStr;
    }

    public static int lengthOfLongestSubStr(String s) {
        if (null == s || s.length() == 0) return 0;
        HashMap<Character, Integer> lastIndexes = new HashMap<>();
        int longest = 0;
        int tmpLength = 0;
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            int lastIndex = lastIndexes.getOrDefault(currentChar, -1);
            tmpLength = i - lastIndex <= tmpLength ? i - lastIndex : tmpLength + 1;
            lastIndexes.put(currentChar, i);
            if (tmpLength > longest) longest = tmpLength;
        }
        return longest;
    }
}
