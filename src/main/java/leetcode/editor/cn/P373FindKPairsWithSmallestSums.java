package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class P373FindKPairsWithSmallestSums {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            // Pair to store in queue (nums1[i], nums2[j], j)
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> (a[0] + a[1])));
            for (int i = 0; i < nums1.length; i++) {
                pq.offer(new int[]{nums1[i], nums2[0], 0});
            }

            List<List<Integer>> res = new ArrayList<>();

            while (!pq.isEmpty() && k > 0) {
                int[] cur = pq.poll();
                int j = cur[2];
                List<Integer> pair = new ArrayList<>();
                pair.add(cur[0]);
                pair.add(cur[1]);
                res.add(pair);
                if (j + 1 < nums2.length) {
                    pq.offer(new int[]{cur[0], nums2[j + 1], j + 1});
                }
                k--;
            }

            return res;

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P373FindKPairsWithSmallestSums().new Solution();
        // put your test code here

    }
}
