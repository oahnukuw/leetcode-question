package leetcode.editor.cn;

import java.util.Arrays;

public class P322CoinChange {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] memo;

        public int coinChange(int[] coins, int amount) {
            memo = new int[amount + 1];
            // Recur
            // Arrays.fill(memo, -2);
            // return recur(coins, amount);
            // Iteration --------------------
            // memo[i] means the minimum coins to achieve amount i

            Arrays.fill(memo, amount + 1);
            memo[0] = 0;
            for (int i = 1; i <= amount; i++) {
                for (int coin : coins) {
                    if (i - coin < 0) {
                        continue;
                    }
                    memo[i] = Math.min(memo[i - coin] + 1, memo[i]);
                }
            }
            return memo[amount] == amount + 1 ? -1 : memo[amount];
        }

        private int recur(int[] coins, int amount) {
            if (amount == 0) {
                return 0;
            }
            if (amount < 0) {
                return -1;
            }
            if (memo[amount] != -2) {
                return memo[amount];
            }
            for (int coin : coins) {
                int subProblem = coinChange(coins, amount - coin);
                if (subProblem == -1) {
                    continue;
                }
                memo[amount] = Math.min(subProblem + 1, memo[amount]);
            }
            return memo[amount] == Integer.MAX_VALUE ? -1 : memo[amount];
        }

    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P322CoinChange().new Solution();
        // put your test code here

    }
}
