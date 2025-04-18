package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P51NQueens {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<String>> res;

        public List<List<String>> solveNQueens(int n) {
            res = new ArrayList<>();
            ArrayList<String> board = new ArrayList<>();
            char[] dot = new char[n];
            Arrays.fill(dot, '.');
            String lineDot = String.valueOf(dot);
            for (int i = 0; i < n; i++) {
                board.add(lineDot);
            }
            backtrack(board, 0);
            return res;
        }

        private void backtrack(ArrayList<String> board, int row) {
            if (row == board.size()) {
                res.add(new ArrayList<>(board));
                return;
            }
            int n = board.get(row).length();
            for (int col = 0; col < n; col++) {
                if (!isValid(board, row, col)) {
                    continue;
                }
                char[] rowChars = board.get(row).toCharArray();
                rowChars[col] = 'Q';
                board.set(row, new String(rowChars));
                backtrack(board, row + 1);
                rowChars[col] = '.';
                board.set(row, new String(rowChars));
            }
        }

        private boolean isValid(ArrayList<String> board, int row, int col) {
            int n = board.size();
            for (int i = 0; i <= row; i++) {
                if (board.get(i).charAt(col) == 'Q') {
                    return false;
                }
            }
            for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
                if (board.get(i).charAt(j) == 'Q') {
                    return false;
                }
            }
            for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
                if (board.get(i).charAt(j) == 'Q') {
                    return false;
                }
            }
            return true;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        // put your test code here

    }
}
