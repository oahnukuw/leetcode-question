package leetcode.editor.cn;

public class P303RangeSumQueryImmutable {

    // leetcode submit region begin(Prohibit modification and deletion)
    class NumArray {
        int[] preSum;

        public NumArray(int[] nums) {
            preSum = new int[nums.length + 1];
            // preSum stores nums[0...i-1]
            for (int i = 1; i < preSum.length; i++) {
                preSum[i] = preSum[i - 1] + nums[i - 1];
            }
        }

        public int sumRange(int left, int right) {
            return preSum[right + 1] - preSum[left];
        }
    }

    /**
     * Your NumArray object will be instantiated and called as such:
     * NumArray obj = new NumArray(nums);
     * int param_1 = obj.sumRange(left,right);
     */
    // leetcode submit region end(Prohibit modification and deletion)
    public static void main(String[] args) {
        // put your test code here

    }
}
