package leetcode.editor.cn;

import java.util.PriorityQueue;

public class P378KthSmallestElementInASortedMatrix {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int kthSmallest(int[][] matrix, int k) {
            int res = Integer.MIN_VALUE;
            // [matrix[i][j],i,j]
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->a[0]-b[0]);
            for (int i = 0; i < matrix.length; i++) {
                pq.offer(new int[]{matrix[i][0], i, 0});
            }
            while (!pq.isEmpty() && k > 0) {
                int[] cur = pq.poll();
                res = cur[0];
                int i = cur[1], j = cur[2];
                // Be careful to the boundary of the matrix
                if (j + 1 < matrix.length) {
                    pq.offer(new int[]{matrix[i][j + 1], i, j + 1});
                }
                k--;
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new P378KthSmallestElementInASortedMatrix().new Solution();
        // put your test code here
        
    }
}
