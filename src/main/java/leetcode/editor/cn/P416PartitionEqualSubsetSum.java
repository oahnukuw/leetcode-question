package leetcode.editor.cn;

import java.util.Arrays;

public class P416PartitionEqualSubsetSum {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] memo;

        public boolean canPartition(int[] nums) {
            int sum = 0;
            for (int num : nums) sum += num;
            if (sum % 2 != 0) return false;
            int n = nums.length;
            sum = sum / 2;
            // bag framework:
            // dp[n][sum] means for n numbers in nums[0..i], sum can be divided into some of them. true/false
            // boolean[][] dp = new boolean[n + 1][sum + 1];
            // for (int i = 0; i <= n; i++) {
            //     dp[i][0] = true;
            // }
            // for (int i = 1; i <= n; i++) {
            //     for (int j = 1; j <= sum; j++) {
            //         if (j - nums[i - 1] < 0) {
            //             dp[i][j] = dp[i - 1][j];
            //         } else {
            //             dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
            //         }
            //     }
            // }
            // return dp[n][sum];
            // recur ---------------------------------------
            memo = new int[nums.length + 1][sum + 1];
            for (int[] row : memo) {
                Arrays.fill(row, -1);
            }
            return recur(nums, n, sum);
            // recur ---------------------------------------

            // dp[sum] means sum can be divided

        }

        // Define: T(n,sum) is whether the sum can be divided by n number in nums[0...n-1]
        private boolean recur(int[] nums, int n, int sum) {
            if (sum == 0) return true;
            if (n == 0) return false;
            if (memo[n][sum] != -1) {
                return memo[n][sum] != 0;
            }
            if (nums[n - 1] > sum) {
                memo[n][sum] = recur(nums, n - 1, sum) ? 1 : 0;
            } else {
                memo[n][sum] = recur(nums, n - 1, sum - nums[n - 1])
                        || recur(nums, n - 1, sum) ? 1 : 0;
            }
            return memo[n][sum] != 0;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P416PartitionEqualSubsetSum().new Solution();
        // put your test code here

    }
}
