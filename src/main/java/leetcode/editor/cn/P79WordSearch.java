package leetcode.editor.cn;

import java.util.LinkedList;

public class P79WordSearch {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        boolean found = false;
        boolean[][] visited;
        LinkedList<Character> track = new LinkedList<>();
        int trackCount = 0;
        public boolean exist(char[][] board, String word) {
            int m = board.length, n = board[0].length;
            visited = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (word.charAt(0) == board[i][j]) {
                        dfs(board, word, i, j);
                    }
                }
            }
            return found;
        }

        private void dfs(char[][] board, String word, int i, int j) {
            int m = board.length, n = board[0].length;
            if (found) {
                return;
            }
            if (trackCount == word.length()) {
                found = true;
                return;
            }
            if (i < 0 || j < 0 || i >= m || j >= n) {
                return;
            }
            if (visited[i][j]) {
                return;
            }
            if (board[i][j] != word.charAt(trackCount)) {
                return;
            }
            trackCount++;
            visited[i][j] = true;
            dfs(board, word, i - 1, j);
            dfs(board, word, i + 1, j);
            dfs(board, word, i, j - 1);
            dfs(board, word, i, j + 1);
            visited[i][j] = false;
            trackCount--;

        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P79WordSearch().new Solution();
        // put your test code here

    }
}
