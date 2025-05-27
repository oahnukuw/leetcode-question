package leetcode.editor.cn;

import java.util.Random;

public class P398RandomPickIndex {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Random random = new Random();
        int[] nums;

        public Solution(int[] nums) {
            this.nums = nums;
        }

        public int pick(int target) {
            int res = 0;
            int k = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != target) {
                    continue;
                }
                k++;
                int r = random.nextInt(k);
                if (r == 0) {
                    res = i;
                }
            }
            return res;
        }
    }

    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(nums);
     * int param_1 = obj.pick(target);
     */
    // leetcode submit region end(Prohibit modification and deletion)
    public static void main(String[] args) {
        // put your test code here

    }
}
