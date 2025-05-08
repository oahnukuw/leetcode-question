package leetcode.editor.cn;

public class P583DeleteOperationForTwoStrings {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] memo;

        public int minDistance(String word1, String word2) {
            int m = word1.length(), n = word2.length();
            // define dp[m][n] is the minimum step to achieve subWord1 being same with subWord2 when length of subWord1 is m and the length of subWord2 is n
            int[][] dp = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++) {
                dp[i][0] = i;
            }
            for (int j = 1; j <= n; j++) {
                dp[0][j] = j;
            }
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + 1;
                    }
                }
            }
            return dp[m][n];

            // dpRecur -------------
            // memo = new int[m][n];
            // for (int[] row : memo) {
            //     Arrays.fill(row, -1);
            // }
            // dpRecur(word1, m - 1, word2, n - 1);
            // return memo[m - 1][n - 1];
            // dpRecur -------------
        }

        // dpRecur(i,j) means the minimum step to make word1 and word2 be same, both i and j are index of word
        int dpRecur(String s1, int i, String s2, int j) {
            if (i == -1) return j + 1;
            if (j == -1) return i + 1;

            if (memo[i][j] != -1) {
                return memo[i][j];
            }
            if (s1.charAt(i) == s2.charAt(j)) {
                memo[i][j] = dpRecur(s1, i - 1, s2, j - 1);
            } else {
                memo[i][j] = Math.min(dpRecur(s1, i - 1, s2, j) + 1, dpRecur(s1, i, s2, j - 1) + 1);
            }
            return memo[i][j];
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P583DeleteOperationForTwoStrings().new Solution();
        // put your test code here

    }
}
