package leetcode.editor.cn;

public class P45JumpGameIi {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int jump(int[] nums) {
            int n = nums.length;
            int farthestIndex = 0;
            int minStep = 0;
            int end = 0;
            for (int i = 0; i < n - 1; i++) {
                farthestIndex = Math.max(i + nums[i], farthestIndex);
                if (end == i) {
                    minStep++;
                    end = farthestIndex;
                }
            }
            return minStep;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P45JumpGameIi().new Solution();
        // put your test code here

    }
}
