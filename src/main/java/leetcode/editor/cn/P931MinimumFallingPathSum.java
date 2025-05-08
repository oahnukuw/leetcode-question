package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P931MinimumFallingPathSum {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] memo;
        int[][] dp;
        public int minFallingPathSum(int[][] matrix) {
            int n = matrix.length;
            int res = Integer.MAX_VALUE;
            // Iteration =================================
            int[][] dp = new int[n][n];
            int[] firstLine = matrix[0];
            System.arraycopy(firstLine, 0, dp[0], 0, firstLine.length);
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (j - 1 < 0) {
                        dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], dp[i - 1][j + 1]);
                    } else if (j + 1 >= n) {
                        dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
                    } else {
                        dp[i][j] = matrix[i][j] + min(dp[i - 1][j - 1], dp[i - 1][j], dp[i - 1][j + 1]);
                    }
                }
            }
            for (int j = 0; j < n; j++) {
                res = Math.min(res, dp[n - 1][j]);
            }

            // Iteration =================================


            // Use Recur------------------------------------------------
            // memo = new int[n][n];
            // for (int[] row : memo) {
            //     Arrays.fill(row,10001);
            // }
            // for (int j = 0; j < n; j++) {
            //     res = Math.min(res, recur(matrix, n - 1, j));
            // }
            // End Recur------------------------------------------------
            return res;
        }

        private int recur(int[][] matrix, int row, int col) {
            int n = matrix.length;
            if (row < 0 || row >= n || col < 0 || col >= n) {
                return 10001;
            }
            if (row == 0) {
                return matrix[0][col];
            }
            if (memo[row][col] != 10001) {
                return memo[row][col];
            }
            int res = 0;
            memo[row][col] = min(
                    recur(matrix, row - 1, col - 1),
                    recur(matrix, row - 1, col),
                    recur(matrix, row - 1, col + 1))
                    + matrix[row][col];
            return memo[row][col];
        }

        private int min(int a, int b, int c) {
            return Math.min(a, Math.min(b, c));
        }

    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        // put your test code here

    }
}
