package leetcode.editor.cn;

import java.util.Arrays;

public class P1143LongestCommonSubsequence {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] memo;

        public int longestCommonSubsequence(String text1, String text2) {
            int m = text1.length(), n = text2.length();
            // dp Iteration-------------
            // dp[i][j] lcs of s1[0..i-1] and s2[0..j-1]
            // i means the num of subString of s1
            // j means the num of subString of s2

            // int[][] dp = new int[m + 1][n + 1];
            // for (int i = 1; i <= m; i++) {
            //     for (int j = 1; j <= n; j++) {
            //         if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
            //             dp[i][j] = dp[i - 1][j - 1] + 1;
            //         } else {
            //             dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            //         }
            //     }
            // }
            // return dp[m][n];
            // dp Iteration-------------
            // dpRecur--------------------------
            memo = new int[m + 1][n + 1];
            for (int[] row : memo) {
                Arrays.fill(row, -1);
            }
            return recur(text1, m, text2, n);
            // dpRecur--------------------------
        }

        // calculate LIS when tex1.len == m and text2.len == n
        private int recur(String text1, int m, String text2, int n) {
            if (m == 0) return 0;
            if (n == 0) return 0;
            if (memo[m][n] != -1) {
                return memo[m][n];
            }
            if (text1.charAt(m - 1) == text2.charAt(n - 1)) {
                memo[m][n] = recur(text1, m - 1, text2, n - 1) + 1;
            } else {
                memo[m][n] = Math.max(recur(text1, m - 1, text2, n), recur(text1, m, text2, n - 1));
            }
            return memo[m][n];
        }

    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        // put your test code here

    }
}
