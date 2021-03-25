package to.geekbang;

/**
 * 有n个骰子
 * 计算每一种骰子点数的和出现的频率
 */
public class Lesson43_SumCount {

    public static void main(String[] args) {
        String result = new Lesson43_SumCount().sumCountTable(1, 2);
        System.out.println(result);
    }


    public String sumCountTable(int n, int sum) {
        int totalCount = (int) Math.pow(6, n);
        if (sum < n || sum > 6 * n) return "0" + "/" + totalCount;

        int[][] result = new int[n][6 * n];
        for (int i = 1; i <= 6 * n; i++) {
            if (i <= 6 && i >= 1)
                result[0][i - 1] = 1;
            else
                result[0][i - 1] = 0;
        }
        for (int i = 1; i <= n; i++) {

        }

        return "" + result[n - 1][sum - 1] + "/" + totalCount;
    }
}
