package to.offer;

import java.util.HashSet;

public class Offer48Solution {

    public static void main(String[] args) {
        String input = "pwwkew";
        System.out.print(longestSubStr(input));
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

    }
}
