package leetcode.editor.cn;

import java.util.*;

public class P862ShortestSubarrayWithSumAtLeastK {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int shortestSubarray(int[] nums, int k) {
            int n = nums.length;
            long[] preSum = new long[n + 1];
            preSum[0] = 0;
            for (int i = 1; i < preSum.length; i++) {
                preSum[i] = preSum[i - 1] + nums[i - 1];
            }
            int left = 0, right = 0;
            int res = Integer.MAX_VALUE;
            MonotonicQueue window = new MonotonicQueue();
            while (right < preSum.length) {
                window.push(preSum[right]);
                right++;
                while (right < preSum.length && !window.isEmpty() && preSum[right] - window.min() >= k) {
                    res = Math.min(res, (right - left));
                    window.pop();
                    left++;
                }
            }
            return res == Integer.MAX_VALUE ? -1 : res;
        }
    }
    class MonotonicQueue {
        LinkedList<Long> q;
        LinkedList<Long> maxQueue;
        LinkedList<Long> minQueue;

        public MonotonicQueue() {
            q = new LinkedList<>();
            maxQueue = new LinkedList<>();
            minQueue = new LinkedList<>();
        }

        public void push(Long elem) {
            // push to normal queue
            q.addLast(elem);

            // push to maxQueue
            while (!maxQueue.isEmpty() && maxQueue.peekLast() < elem) {
                maxQueue.pollLast();
            }
            maxQueue.addLast(elem);

            // push to minQueue
            while (!minQueue.isEmpty() && minQueue.peekLast() > elem) {
                minQueue.pollLast();
            }
            minQueue.addLast(elem);
        }

        public Long pop() {
            if (q.isEmpty()) {
                return null;
            }
            Long delValue = q.pop();

            if (delValue.equals(maxQueue.getFirst())) {
                maxQueue.pollFirst();
            }

            if (delValue.equals(minQueue.getFirst())) {
                minQueue.pollFirst();
            }
            return delValue;
        }

        public Long max() {
            return maxQueue.peekFirst();
        }

        public Long min() {
            return minQueue.peekFirst();
        }

        public int size() {
            return q.size();
        }

        public boolean isEmpty() {
            return q.isEmpty();
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P862ShortestSubarrayWithSumAtLeastK().new Solution();
        // put your test code here
        
    }
}
