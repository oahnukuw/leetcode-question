package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P1631PathWithMinimumEffort {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumEffortPath(int[][] heights) {
            int m = heights.length;
            int n = heights[0].length;
            int[][] distTo = dijkstra(heights, 0, 0);
            return distTo[m - 1][n - 1];
        }

        private int[][] dijkstra(int[][] heights, int i, int j) {
            int[][] dirs = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
            int m = heights.length;
            int n = heights[0].length;
            int[][] distTo = new int[m][n];
            for (int[] row : distTo) {
                Arrays.fill(row, -1);
            }
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
            pq.offer(new int[]{i, j, 0});
            while (!pq.isEmpty()) {
                // cur{i,j,maxDiffVal}
                int[] cur = pq.poll();
                int curI = cur[0];
                int curJ = cur[1];
                int curHeight = cur[2];
                if (distTo[curI][curJ] != -1) {
                    continue;
                }

                distTo[curI][curJ] = curHeight;
                if (curI == m - 1 && curJ == n - 1) {
                    return distTo;
                }

                for (int[] dir : dirs) {
                    int nextI = dir[0] + curI;
                    int nextJ = dir[1] + curJ;
                    if (nextI < 0 || nextJ < 0 || nextI > m - 1 || nextJ > n - 1) {
                        continue;
                    }
                    if (distTo[nextI][nextJ] == -1) {
                        pq.offer(new int[]{nextI, nextJ, Math.max(curHeight, Math.abs(heights[nextI][nextJ] - heights[curI][curJ]))});
                    }
                }
            }
            return distTo;
        }


    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P1631PathWithMinimumEffort().new Solution();
        // put your test code here

    }
}
