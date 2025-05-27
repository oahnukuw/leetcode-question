package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class P239SlidingWindowMaximum {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int left = 0, right = 0;
            Deque<Integer> monotonicQueue = new LinkedList<>();
            int[] res = new int[nums.length - k + 1];
            int resIndex = 0;
            while (right < nums.length) {
                while (!monotonicQueue.isEmpty() && monotonicQueue.peekLast() < nums[right]) {
                    monotonicQueue.pollLast();
                }
                monotonicQueue.offer(nums[right]);
                right++;
                if (right - left == k) {
                    int queueHead = monotonicQueue.peek();
                    res[resIndex++] = queueHead;
                    if (queueHead == nums[left]) {
                        monotonicQueue.poll();
                    }
                    left++;
                }
            }
            return res;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P239SlidingWindowMaximum().new Solution();
        // put your test code here
        solution.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);

    }
}
