package leetcode.editor.cn;

public class P37SudokuSolver {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        boolean found = false;

        public void solveSudoku(char[][] board) {
            backtrack(board, 0);

        }

        private void backtrack(char[][] board, int index) {
            if (found) return;
            int m = 9, n = 9;
            int i = index / n, j = index % n;
            if (index == m * n) {
                found = true;
                return;
            }

            if (board[i][j] != '.') {
                backtrack(board, index + 1);
                return;
            }
            for (char ch = '1'; ch <= '9'; ch++) {
                if (!valid(board, i, j, ch)) {
                    continue;
                }

                board[i][j] = ch;
                backtrack(board, index + 1);
                if (found) return;
                board[i][j] = '.';
            }
        }

        private boolean valid(char[][] board, int r, int c, char num) {
            for (int i = 0; i < board.length; i++) {
                if (board[i][c] == num) {
                    return false;
                }
                if (board[r][i] == num) {
                    return false;
                }
                if (board[r / 3 * 3 + i / 3][c / 3 * 3 + i % 3] == num) {
                    return false;
                }
            }

            return true;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P37SudokuSolver().new Solution();
        // put your test code here

    }
}
