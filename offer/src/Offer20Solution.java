/***
 * 剑指 Offer 20. 表示数值的字符串
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"0123"都表示数值，
 * 但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
 */
public class Offer20Solution {

    public static void main(String[] args) {
        //基础验证
        double a=1e6;
        System.out.println(a);
    }

    /**
     * 方法1：确定有限状态机
     * @param s
     * @return
     */
    public boolean isNumber(String s) {
        return false;
    }
}
