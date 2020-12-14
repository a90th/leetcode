package to.offer;

/**
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。
 * 在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 * <p>
 * 请写一个函数，求任意第n位对应的数字。
 * 示例 1：
 * 输入：n = 3
 * 输出：3
 * 示例 2：
 * 输入：n = 11
 * 输出：0
 */
public class Offer44Solution {
    public static int findNthDigit(int n) {
        if (n < 10) return n;
        int digits = 2;
        int base = 10;
        n = n - 10;
        while (n >= digits * base * 9) {
            n = n - digits * base * 9;
            digits++;
            base = base * 10;
        }
        int currentNum = base + n / digits;
        int index = n % digits;
        for (int i = 0; i < index; i++) {
            currentNum = currentNum % base;
            base = base / 10;
        }
        return currentNum / base;
    }

    public static void main(String[] args) {
        int result = findNthDigit(1000000000);
        System.out.print(result);
    }
}
