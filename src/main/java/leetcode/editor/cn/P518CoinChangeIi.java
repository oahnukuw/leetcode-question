package leetcode.editor.cn;

import java.util.Arrays;

public class P518CoinChangeIi {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] memo;
        public int change(int amount, int[] coins) {
            memo = new int[coins.length + 1][amount + 1];
            for (int[] row : memo) {
                Arrays.fill(row, -1);
            }
            return recur(coins.length, amount, coins);
        }

        private int recur(int coinType, int amount, int[] coins) {
            if (coinType == 0) return 0;
            if (amount == 0) return 1;
            if (memo[coinType][amount] != -1) {
                return memo[coinType][amount];
            }
            if (amount >= coins[coinType - 1]) {
                memo[coinType][amount] = recur(coinType, amount - coins[coinType - 1], coins) + recur(coinType - 1, amount, coins);
            } else {
                memo[coinType][amount] = recur(coinType - 1, amount, coins);
            }
            return memo[coinType][amount];
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P518CoinChangeIi().new Solution();
        // put your test code here

    }
}
