package leetcode.editor.cn;

public class P509FibonacciNumber {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] memo;

        public int fib(int n) {
            // memo = new int[n+1];
            // Arrays.fill(memo, -1);
            // return dp(n);
            if (n == 0 || n == 1) return n;
            int dp_i_1 = 1, dp_i_2 = 0;
            for (int i = 2; i <= n; i++) {
                int dp_i = dp_i_1 + dp_i_2;
                dp_i_2 = dp_i_1;
                dp_i_1 = dp_i;
            }
            return dp_i_1;
        }

        private int dp(int n) {
            if (n == 0 || n == 1) return n;
            if (memo[n] != -1) return memo[n];
            memo[n] = dp(n - 1) + dp(n - 2);
            return memo[n];
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P509FibonacciNumber().new Solution();
        // put your test code here

    }
}
