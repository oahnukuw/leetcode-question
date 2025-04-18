package leetcode.editor.cn;

import java.util.Arrays;

public class P52NQueensIi {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int res = 0;
        public int totalNQueens(int n) {
            // 1. build up a board for fill queens
            String[] board = new String[n];
            char[] dot = new char[n];
            Arrays.fill(dot, '.');
            String nDot = String.valueOf(dot);
            Arrays.fill(board, nDot);
            backtrack(board, 0);
            return res;
        }

        private void backtrack(String[] board, int row) {
            if (row == board.length) {
                res++;
                return;
            }
            for (int col = 0; col < board.length; col++) {
                if (!isValid(board, row, col)) {
                    continue;
                }
                char[] chars = board[row].toCharArray();
                chars[col] = 'Q';
                board[row] = String.valueOf(chars);
                backtrack(board, row + 1);
                chars[col] = '.';
                board[row] = String.valueOf(chars);
            }
        }

        private boolean isValid(String[] board, int row, int col) {
            for (int i = row - 1; i >= 0; i--) {
                if (board[i].charAt(col)=='Q') {
                    return false;
                }
            }
            for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
                if (board[i].charAt(j) == 'Q') {
                    return false;
                }
            }
            for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
                if (board[i].charAt(j) == 'Q') {
                    return false;
                }
            }
            return true;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P52NQueensIi().new Solution();
        // put your test code here

    }
}
