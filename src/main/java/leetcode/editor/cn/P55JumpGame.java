package leetcode.editor.cn;

public class P55JumpGame {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean canJump(int[] nums) {
            int n = nums.length;
            int farthest = 0;
            for (int i = 0; i < n-1; i++) {
                farthest = Math.max(i + nums[i], farthest);
                if (farthest <= i) {
                    return false;
                }
            }
            return farthest >= n - 1;
            // brute force
            // return dfs(nums, 0);
        }

        // private boolean dfs(int[] nums, int curIndex) {
        //     if (curIndex >= nums.length - 1) return true;
        //     int farthest = curIndex;
        //     int nextIndex = curIndex;
        //     for (int i = 1; i <= nums[curIndex]; i++) {
        //         if (curIndex + i < nums.length) {
        //             if (farthest < nums[curIndex + i] + curIndex + i) {
        //                 nextIndex = curIndex + i;
        //                 farthest = nums[curIndex + i] + curIndex + i;
        //             }
        //         }
        //     }
        //     if (nextIndex > curIndex) {
        //         boolean dfs = dfs(nums, nextIndex);
        //         if (dfs) {
        //             return true;
        //         }
        //     }
        //     return false;
        // }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P55JumpGame().new Solution();
        solution.canJump(new int[]{5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0});
        // put your test code here

    }
}
