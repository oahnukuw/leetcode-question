package leetcode.editor.cn;

import java.util.Arrays;

public class P712MinimumAsciiDeleteSumForTwoStrings {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] memo;
        int res = 0;

        public int minimumDeleteSum(String s1, String s2) {
            int m = s1.length(), n = s2.length();
            // dpRecur----------------------
            // memo = new int[m][n];
            // for (int[] row : memo) {
            //     Arrays.fill(row, -1);
            // }
            // return dpRecur(s1, m - 1, s2, n - 1);
            // dpRecur----------------------

            // Iteration-------------------------------------------
            // dp[i][j] means when s1.length = i, s2.length = j, the Ascii Sum of deleted char

            int[][] dp = new int[m + 1][n + 1];
            // base case
            for (int i = 1; i <= m; i++) {
                dp[i][0] = dp[i - 1][0] + s1.charAt(i - 1);
            }
            for (int j = 1; j <= n; j++) {
                dp[0][j] = dp[0][j - 1] + s2.charAt(j - 1);
            }
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (s1.charAt(i-1) == s2.charAt(j-1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Math.min(dp[i][j - 1] + s2.charAt(j-1), dp[i - 1][j] + s1.charAt(i-1));
                    }
                }
            }
            return dp[m][n];
            // Iteration-------------------------------------------
        }

        private int dpRecur(String s1, int i, String s2, int j) {
            int res = 0;
            if (i == -1) {
                for (; j >= 0; j--) {
                    res += s2.charAt(j);
                }
                return res;
            }
            if (j == -1) {
                for (; i >= 0; i--) {
                    res += s1.charAt(i);
                }
                return res;
            }
            if (memo[i][j] != -1) {
                return memo[i][j];
            }
            if (s1.charAt(i) == s2.charAt(j)) {
                memo[i][j] = dpRecur(s1, i - 1, s2, j - 1);
            } else {
                memo[i][j] = Math.min(
                        s1.charAt(i) + dpRecur(s1, i - 1, s2, j),
                        s2.charAt(j) + dpRecur(s1, i, s2, j - 1)
                );
            }
            return memo[i][j];
        }

    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        // put your test code here

    }
}
