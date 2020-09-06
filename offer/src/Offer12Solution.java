/***
 * 剑指 Offer 12. 矩阵中的路径
 *
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。
 * 如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
 *
 * 可以划线连接要求的字母
 * 例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 *
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 *
 * 示例 1：
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 *
 * 示例 2：
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 * 提示：
 *
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 */
public class Offer12Solution {

    public static void main(String[] args) {
        //基础验证
//        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
//        String word = "ABCCED";
        char[][] board = {{'A', 'B'}};
        String word = "BA";
        System.out.println(new Offer12Solution().exist(board,word));
    }

    /**
     * 方法1：暴力解法,递归验证。
     * 唯一可递归的参数是当前字母的位置，而不是board的划片
     * 时间复杂度：O(3^K*M*N)
     *
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || null == word || word.length() == 0) return false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(board, word.toCharArray(), i, j, 0)) return true;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        //越界返回false，结束查找；
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[i].length - 1) return false;
        //字母不相等返回false，结束查找；
        if (board[i][j] != word[k]) return false;
        //所有字母已经匹配返回true，结束查找；
        if (k == word.length - 1) return true;
        //将当前位置改为不可匹配
        char tmp = board[i][j];
        board[i][j] = '/';
        boolean result = dfs(board, word, i - 1, j, k + 1) || dfs(board, word, i + 1, j, k + 1) ||
                dfs(board, word, i, j - 1, k + 1) || dfs(board, word, i, j + 1, k + 1);
        board[i][j] = tmp;
        return result;
    }
}
