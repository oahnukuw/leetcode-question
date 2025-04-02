package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.cn.common.*;

public class P918MaximumSumCircularSubarray {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubarraySumCircular(int[] nums) {
            int n = nums.length;
            int[] preSum = new int[2 * n + 1];
            for (int i = 1; i < preSum.length; i++) {
                preSum[i] = preSum[i - 1] + nums[(i - 1) % n];
            }

            MonotonicQueue window = new MonotonicQueue();
            int maxSum = Integer.MIN_VALUE;
            window.push(0);

            for (int i = 1; i < preSum.length; i++) {
                maxSum = Math.max(maxSum, preSum[i] - window.min());
                if (window.size() == n) {
                    window.pop();
                }
                window.push(preSum[i]);
            }
            return maxSum;
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
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new P918MaximumSumCircularSubarray().new Solution();
        // put your test code here
        
    }
}
