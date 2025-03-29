package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class P933NumberOfRecentCalls {

    // leetcode submit region begin(Prohibit modification and deletion)
    class RecentCounter {
        Queue<Integer> queue = new LinkedList<>();

        public RecentCounter() {

        }

        public int ping(int t) {
            queue.offer(t);
            while (!queue.isEmpty() && queue.peek() < t - 3000) {
                queue.poll();
            }
            return queue.size();
        }
    }

    /**
     * Your RecentCounter object will be instantiated and called as such:
     * RecentCounter obj = new RecentCounter();
     * int param_1 = obj.ping(t);
     */
    // leetcode submit region end(Prohibit modification and deletion)
    public static void main(String[] args) {
        // put your test code here

    }
}
