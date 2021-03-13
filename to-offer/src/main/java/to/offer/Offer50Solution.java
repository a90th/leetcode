package to.offer;

import java.nio.charset.CharacterCodingException;
import java.util.*;

/**
 * 在字符串 s 中找出第一个只出现一次的字符。
 * 如果没有，返回一个单空格。 s 只包含小写字母。
 * 示例:
 * <p>
 * s = "abaccdeff"
 * 返回 "b"
 * s = ""
 * 返回 " "
 */
public class Offer50Solution {

    //可以使用桶的思想，针对有限可能集问题
    public static char firstUniqChar(String s) {
        int[] count = new int[26];
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            count[currentChar - 'a']++;
            lastIndex[currentChar - 'a'] = i;
        }
        char result = ' ';
        int minIndex = s.length();
        for (int i = 0; i < 26; i++) {
            if (count[i] == 1 && lastIndex[i] < minIndex) {
                minIndex = lastIndex[i];
                result = (char) ('a' + i);
            }
        }
        return result;
    }

    public static char firstUniqChar2(String s) {
        HashMap<Character, Integer> firstIndex = new HashMap<>();
        HashMap<Character, Integer> multiIndex = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (!firstIndex.containsKey(currentChar) && !multiIndex.containsKey(currentChar)) {
                firstIndex.put(currentChar, i);
            } else {
                firstIndex.remove(currentChar);
                multiIndex.put(currentChar, i);
            }
        }
        if (firstIndex.isEmpty()) return ' ';
        else {
            int minIndex = s.length();
            char result = ' ';
            for (Map.Entry<Character, Integer> entry : firstIndex.entrySet()) {
                if (entry.getValue() < minIndex) {
                    minIndex = entry.getValue();
                    result = entry.getKey();
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        String s = "abaccdeff";
        System.out.print(firstUniqChar(s));
    }

}
