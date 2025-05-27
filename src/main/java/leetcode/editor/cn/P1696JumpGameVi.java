package leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;

public class P1696JumpGameVi {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] memo;

        public int maxResult(int[] nums, int k) {
            int n = nums.length;
            // Recurrence -----------------------------------------------------------------
            // memo = new int[n];
            // Arrays.fill(memo, Integer.MIN_VALUE);
            // return recur(nums, k, n - 1);
            // Recurrence -----------------------------------------------------------------

            // DP Monotonic Queue---------------------------------------------------------------
            int[] dp = new int[n];
            Arrays.fill(dp, Integer.MIN_VALUE);
            MonotonicQue window = new MonotonicQue();
            dp[0] = nums[0];
            window.offer(dp[0]);
            for (int i = 1; i < n; i++) {
                dp[i] = window.getMax() + nums[i];
                if (window.size() == k) {
                    window.poll();
                }
                window.offer(dp[i]);
            }
            return dp[n - 1];
            // DP Monotonic Queue---------------------------------------------------------------
        }

        private int recur(int[] nums, int k, int i) {
            // Base case
            if (i < 0) return Integer.MIN_VALUE;
            if (i == 0) return nums[0];
            if (memo[i] != Integer.MIN_VALUE) {
                return memo[i];
            }
            for (int j = 1; j <= k; j++) {
                memo[i] = Math.max(memo[i], recur(nums, k, i - j));
            }
            memo[i] += nums[i];
            return memo[i];
        }

        class MonotonicQue {
            LinkedList<Integer> que = new LinkedList<>();
            LinkedList<Integer> maxQue = new LinkedList<>();
            LinkedList<Integer> minQue = new LinkedList<>();

            void offer(int e) {
                while (!maxQue.isEmpty() && maxQue.peekLast() < e) {
                    maxQue.pollLast();
                }
                maxQue.offer(e);
                while (!minQue.isEmpty() && minQue.peekLast() > e) {
                    minQue.pollLast();
                }
                minQue.offer(e);
                que.offer(e);
            }

            int poll() {
                if (que.isEmpty()) {
                    return -1;
                }
                Integer delVal = que.poll();
                if (delVal.equals(maxQue.peek())) {
                    maxQue.pollFirst();
                }
                if (delVal.equals(minQue.peek())) {
                    minQue.pollFirst();
                }
                return delVal;
            }

            Integer getMax() {
                return maxQue.peekFirst();
            }

            public int size() {
                return que.size();
            }
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P1696JumpGameVi().new Solution();
        // put your test code here

    }
}
