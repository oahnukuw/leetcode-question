package leetcode.editor.cn;

public class P1658MinimumOperationsToReduceXToZero {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minOperations(int[] nums, int x) {
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
            }
            int target = sum - x;
            int l = 0, r = 0;
            int maxLen = Integer.MIN_VALUE;
            int resSum = 0;
            // Window is consist of numbers between [l, r)
            // Use the sum of elements in the window to decide when enlarge or shrink the window

            while (r < nums.length) {
                // Enlarge the window
                resSum += nums[r];
                r++;

                // Shrink the window
                while (resSum > target && l < r) {
                    resSum -= nums[l];
                    l++;
                }

                if (resSum == target) {
                    // Update answer
                    maxLen = Math.max(maxLen, r - l);
                }
            }
            return maxLen == Integer.MIN_VALUE ? -1 : (nums.length - maxLen);
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P1658MinimumOperationsToReduceXToZero().new Solution();
        // put your test code here

    }
}
