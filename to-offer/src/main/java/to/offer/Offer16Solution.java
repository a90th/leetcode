package to.offer;

/***
 * 剑指 Offer 16. 数值的整数次方
 * 实现函数double Power(double base, int exponent)，求base的exponent次方。
 * 不得使用库函数，同时不需要考虑大数问题。
 *
 * 示例 1:
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 *
 * 示例2:
 * 输入: 2.10000, 3
 * 输出: 9.26100
 *
 * 示例3:
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2^-2 = 1/2^2 = 1/4 = 0.25
 *
 * 说明:
 * -100.0 <x< 100.0
 * n是 32 位有符号整数，其数值范围是[−2^31,2^31− 1] 。
 */
public class Offer16Solution {

    public static void main(String[] args) {
        //基础验证
        double result = new Offer16Solution().myPow(2.000,-2147483648);
        System.out.println(result);
    }

    public double myPow(double x, int n) {
        if (0 == x) return 0;
        //n为负数是获得相反数超限，所以先以long型保存
        long b = n;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        double result = 1;
        //x^n=x^(1*b1+2*b2+4*b3+...+2^(m-1)*bm)依次获得二进制位是0还是1
        //x^2=x*x;x^4=x^2*x^2
        //可以从二进制角度，或者二分法角度理解，二进制角度更加直接
        while (b != 0) {
            long bi = b & 1;
            result *= 1 == bi ? x : 1;
            x *= x;
            b >>>= 1;
        }
        return result;
    }
}
