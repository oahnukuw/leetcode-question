package leetcode.editor.cn;

import java.util.Arrays;

public class P72EditDistance {

    // Define T(m,n) is the minimum edit number where m is the length of word1 and n is the length of word2.
    // 1) Base case: T(0,0) is zero, because no edit when both word1 and word2 are empty string
    // T(0,n) = n. Because transforming empty word1 into subWord of word2 whose length is n, need to insert n chars. Vice and verse T(m,0) = m. Because when the length of subWord in word2 is 0, delete m chars of the word1.
    // 2) Consider how many sub cases can achieve T(m,n). When calculate T(m,n) and word1[m-1]!=word2[n-1], it can be achieved by
    // T(m-1,n-1): replace word1[m-1] to word[n-1],
    // T(m-1,n): insert a char,
    // T(m,n-1): delete a char.
    // So in such case, T(m,n)= min{T(m-1,n-1),T(m-1,n),T(m,n-1)}+1
    //
    // What if word1[m-1]==word2[n-1]? We can achieve T(m,n) by T(m-1,n-1), because we need do nothing from this case, just because word1[m-1]!=word2[n-1].
    //
    // So this is the Recurrence:
    // T(m,n)=m, n=0
    // T(m,n)=n, m=0
    // T(m,n)=T(m-1,n-1), word1[m-1]==word[n-1], m>1, n>1
    // T(m,n)=min{T(m-1,n-1),T(m-1,n),T(m,n-1)}+1, word1[m-1]!=word[n-1], m>1, n>1
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] memo;

        public int minDistance(String word1, String word2) {
            int m = word1.length();
            int n = word2.length();
            // Recursive call
            memo = new int[m + 1][n + 1];
            for (int[] ints : memo) {
                Arrays.fill(ints, -1);
            }
            return recur(word1, m, word2, n);
            // Iterative  call
            // Base case
            // memo[i][j] means [0..i-1][0...j-1] the shortest editDistance
            // i means the num of subString of word1
            // j means the num of subString of word2
            // memo = new int[m + 1][n + 1];
            // for (int i = 1; i <= m; i++) {
            //     memo[i][0] = i;
            // }
            // for (int j = 1; j <= n; j++) {
            //     memo[0][j] = j;
            // }
            // for (int i = 1; i <= m; i++) {
            //     for (int j = 1; j <= n; j++) {
            //         if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
            //             memo[i][j] = memo[i - 1][j - 1];
            //         } else {
            //             memo[i][j] = getMin(
            //                     memo[i - 1][j] + 1,
            //                     memo[i][j - 1] + 1,
            //                     memo[i - 1][j - 1] + 1
            //             );
            //         }
            //     }
            // }
            // return memo[m][n];
        }

        private int recur(String word1, int m, String word2, int n) {
            if (m == 0) return n;
            if (n == 0) return m;
            if (memo[m][n] != -1) {
                return memo[m][n];
            }
            if (word1.charAt(m - 1) == word2.charAt(n - 1)) {
                memo[m][n] = recur(word1, m - 1, word2, n - 1);
            } else {
                memo[m][n] = getMin(recur(word1, m - 1, word2, n), recur(word1, m, word2, n - 1), recur(word1, m - 1, word2, n - 1)) + 1;
            }
            return memo[m][n];
        }


        private int getMin(int a, int b, int c) {
            return Math.min(a, Math.min(b, c));
        }

    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P72EditDistance().new Solution();
        // put your test code here

    }
}
