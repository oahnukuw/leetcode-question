package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.IntStream;

public class P239SlidingWindowMaximum {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            // Deque<Integer> minStack = new ArrayDeque<>(k);
            int left = 0, right = 0;
            int max = Integer.MIN_VALUE;
            Deque<Integer> window = new LinkedList<>();
            ArrayList<Integer> res = new ArrayList<>();
            while (right < nums.length) {
                int rNum = nums[right];
                while (!window.isEmpty() && window.peekLast() < rNum) {
                    window.pollLast();
                }
                window.addLast(rNum);
                right++;
                if (right - left == k) {
                    int lNum = nums[left];
                    if (!window.isEmpty()) {
                        Integer maxVal = window.peekFirst();
                        if (maxVal == lNum) {
                            window.pollFirst();
                        }
                        res.add(maxVal);
                    }
                    left++;
                }
            }
            return res.stream().flatMapToInt(IntStream::of).toArray();
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P239SlidingWindowMaximum().new Solution();
        // put your test code here
        solution.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);

    }
}
