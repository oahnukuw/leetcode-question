package leetcode.editor.cn;

import java.util.Stack;

public class P581ShortestUnsortedContinuousSubarray {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findUnsortedSubarray(int[] nums) {
            int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;
            int n = nums.length;
            Stack<Integer> incrStack = new Stack<>();
            for (int i = 0; i < n; i++) {
                while (!incrStack.isEmpty() && nums[incrStack.peek()] > nums[i]) {
                    left = Math.min(left, incrStack.pop());
                }
                incrStack.push(i);
            }

            Stack<Integer> descStack = new Stack<>();
            for (int i = n - 1; i >= 0; i--) {
                while (!descStack.isEmpty() && nums[descStack.peek()] < nums[i]) {
                    right = Math.max(right, descStack.pop());
                }
                descStack.push(i);
            }
            if (left == Integer.MAX_VALUE && right == Integer.MIN_VALUE) {
                return 0;
            }
            return right - left + 1;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P581ShortestUnsortedContinuousSubarray().new Solution();
        // put your test code here

    }
}
