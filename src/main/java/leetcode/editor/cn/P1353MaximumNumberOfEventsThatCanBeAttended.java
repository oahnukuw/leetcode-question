package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P1353MaximumNumberOfEventsThatCanBeAttended {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxEvents(int[][] events) {
            Arrays.sort(events, Comparator.comparing(a -> a[0]));
            int count = 0;
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            int index = 0, day = events[0][0];
            // Day is a key. Keep meetings start from today, and deport meetings ending before today. Then pickup a meeting which has the earliest end date to participate.
            // 对于每一天，要找当天已经开始了，却最快结束的会议来参加。
            // 为了做到这点，得先把早于今天结束的会议给丢掉。并且，把今天开始的会议给加入到优先队列中。
            while (index < events.length || !pq.isEmpty()) {
                while (index < events.length && events[index][0] == day) {
                    pq.offer(events[index][1]);
                    index++;
                }
                while (!pq.isEmpty() && pq.peek() < day) {
                    pq.poll();
                }
                if (!pq.isEmpty()) {
                    Integer curEnd = pq.poll();
                    if (curEnd >= day) {
                        count++;
                    }
                }
                day++;
            }
            return count;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P1353MaximumNumberOfEventsThatCanBeAttended().new Solution();
        // put your test code here
        solution.maxEvents(new int[][]{
                {1, 5},
                {1, 5},
                {1, 5},
                {2, 3},
                {2, 3},
        });

    }
}
