package leetcode.editor.cn;

public class P53MaximumSubarray {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] memo;

        public int maxSubArray(int[] nums) {
            // return slideWindow(nums);
            // return dp(nums);
            // return calculatePreSum(nums);
            int dp_0 = nums[0];
            int maxSum = nums[0];
            for (int i = 1; i < nums.length; i++) {
                dp_0 = Math.max(dp_0 + nums[i], nums[i]);
                maxSum = Math.max(dp_0, maxSum);
            }
            return maxSum;
        }

        private int calculatePreSum(int[] nums) {
            int n = nums.length;
            int[] preSum = new int[n + 1];
            preSum[0] = 0;
            int minPresum = Integer.MAX_VALUE;
            int res = Integer.MIN_VALUE;
            for (int i = 1; i <= n; i++) {
                preSum[i] = nums[i - 1] + preSum[i - 1];
                minPresum = Math.min(preSum[i - 1], minPresum);
                res = Math.max(res, preSum[i] - minPresum);
            }
            // return res == Integer.MIN_VALUE ? nums[0] : res;
            return res;
        }


        private int slideWindow(int[] nums) {
            int left = 0, right = 0;
            int windowSum = 0;
            int res = Integer.MIN_VALUE;
            while (right < nums.length) {
                windowSum += nums[right];
                right++;

                res = Math.max(res, windowSum);

                while (windowSum < 0) {
                    windowSum -= nums[left];
                    left++;
                }
            }
            return res;

        }

    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P53MaximumSubarray().new Solution();
        // put your test code here

    }
}
