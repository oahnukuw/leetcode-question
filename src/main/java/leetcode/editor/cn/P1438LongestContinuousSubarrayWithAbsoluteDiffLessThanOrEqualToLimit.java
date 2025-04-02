package leetcode.editor.cn;

import java.util.LinkedList;

public class P1438LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestSubarray(int[] nums, int limit) {
            int n = nums.length;
            MonotonicQueue window = new MonotonicQueue();
            int left = 0, right = 0;
            int res = 0;

            while (right < n) {
                window.push(nums[right]);
                right++;

                while (window.max() - window.min() > limit) {
                    window.pop();
                    left++;
                }

                res = Math.max(res, right - left);

            }

            return res;
        }
    }

    class MonotonicQueue {
        LinkedList<Integer> q;
        LinkedList<Integer> maxQueue;
        LinkedList<Integer> minQueue;

        public MonotonicQueue() {
            q = new LinkedList<>();
            maxQueue = new LinkedList<>();
            minQueue = new LinkedList<>();
        }

        public void push(Integer elem) {
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

        public Integer pop() {
            if (q.isEmpty()) {
                return null;
            }
            Integer delValue = q.pop();

            if (delValue.equals(maxQueue.getFirst())) {
                maxQueue.pollFirst();
            }

            if (delValue.equals(minQueue.getFirst())) {
                minQueue.pollFirst();
            }
            return delValue;
        }

        public Integer max() {
            return maxQueue.peekFirst();
        }

        public Integer min() {
            return minQueue.peekFirst();
        }

        public int size() {
            return q.size();
        }

        public boolean isEmpty() {
            return q.isEmpty();
        }

    }
    // leetcode submit region end(Prohibit modification and deletion)



    public static void main(String[] args) {
        // put your test code here

    }
}
