package leetcode.editor.cn;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P1705MaximumNumberOfEatenApples {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int eatenApples(int[] apples, int[] days) {
            // 我要吃最快腐烂的苹果该怎么办？
            // 记录到今天为止还可以吃的苹果，但是要吃最快腐烂的
            int count = 0;
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
            // int[][]{expiredDay,num}
            int i = 0, n = apples.length;
            while (i < n || !pq.isEmpty()) {
                if (i < n && apples[i] > 0) {
                    pq.offer(new int[]{i + days[i], apples[i]});
                }
                while (!pq.isEmpty() && (pq.peek()[0] <= i || pq.peek()[1] == 0)) {
                    pq.poll();
                }
                if (!pq.isEmpty()) {
                    pq.peek()[1]--;
                    count++;
                }
                i++;
            }
            return count;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P1705MaximumNumberOfEatenApples().new Solution();
        // put your test code here

    }
}
