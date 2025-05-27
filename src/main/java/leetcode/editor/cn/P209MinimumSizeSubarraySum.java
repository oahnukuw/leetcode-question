package leetcode.editor.cn;

public class P209MinimumSizeSubarraySum {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int sum = 0;
            int left = 0, right = 0;
            int res = Integer.MAX_VALUE;
            while (right < nums.length) {
                sum += nums[right++];

                while (sum >= target) {
                    res = Math.min(res, right - left);
                    sum -= nums[left++];
                }

            }
            return res == Integer.MAX_VALUE ? 0 : res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new P209MinimumSizeSubarraySum().new Solution();
        // put your test code here
        
    }
}
