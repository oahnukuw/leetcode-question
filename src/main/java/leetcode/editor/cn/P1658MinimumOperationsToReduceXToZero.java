package leetcode.editor.cn;

public class P1658MinimumOperationsToReduceXToZero {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minOperations(int[] nums, int x) {
            int left = 0, right = 0;
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            int target = sum - x;
            int partSum = 0;
            int res = Integer.MAX_VALUE;
            while (right < nums.length) {
                partSum += nums[right++];
                while (partSum > target && left < right) {
                    partSum -= nums[left++];
                }
                if (partSum == target) {
                    res = Math.min(nums.length - (right - left), res);
                }
            }
            return res == Integer.MAX_VALUE ? -1 : res;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P1658MinimumOperationsToReduceXToZero().new Solution();
        // put your test code here

    }
}
