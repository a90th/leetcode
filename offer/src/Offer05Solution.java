/***
 * 剑指 Offer 05. 替换空格
 *
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"
 *
 * 示例 1：
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *
 * 限制：
 * 0 <= s 的长度 <= 10000
 */
public class Offer05Solution {

    public static void main(String[] args) {
        //Step1:基础验证
        String originStr = "We are happy.";
        String result = new Offer05Solution().replaceSpace2(originStr);
        System.out.println(result);
    }

    /**
     * 方法1：使用jdk的原生方法
     * <p>
     * JDK中String的replace使用了正则表达式
     *
     * @param s
     * @return
     */
    public String replaceSpaceUseJDK(String s) {
        return s.replace(" ", "%20");
    }

    /**
     * 方法2：使用StringBuilder
     * 时间复杂度：O(n)
     * 空间耗用：O(n)
     * 主要考虑的是替换过程中字符串的存储问题
     *
     * @param s
     * @return
     */
    public String replaceSpace1(String s) {
        StringBuilder newStr = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (' ' == (s.charAt(i))) {
                newStr.append("%20");
            } else {
                newStr.append(s.charAt(i));
            }
        }
        return newStr.toString();
    }

    /**
     * 方法3： 官方解法，将字符串视为字符数组进行操作
     *
     * leetcode平台测试时间+空间与jdk方案没有明显区别
     * @param s
     * @return
     */
    public String replaceSpace2(String s) {
        int length = s.length();
        char[] array = new char[length * 3];
        int size = 0;
        for (int i = 0; i < length; i++) {
            if (' ' == s.charAt(i)) {
                array[size++]='%';
                array[size++]='2';
                array[size++]='0';
            } else {
                array[size++] = s.charAt(i);
            }
        }
        return new String(array,0,size);
    }
}
