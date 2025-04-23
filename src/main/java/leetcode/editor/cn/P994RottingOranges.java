package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class P994RottingOranges {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        final int[][] dirs = new int[][]{
                {0, 1},
                {0, -1},
                {1, 0},
                {-1, 0},
        };

        public int orangesRotting(int[][] grid) {
            Queue<int[]> q = new LinkedList<>();
            int m = grid.length, n = grid[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 2) {
                        q.offer(new int[]{i, j});
                    }
                }
            }
            int step = 0;
            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    int[] cur = q.poll();
                    for (int[] dir : dirs) {
                        int x = cur[0] + dir[0];
                        int y = cur[1] + dir[1];
                        if (x < 0 || y < 0 || x >= m || y >= n) {
                            continue;
                        }
                        if (grid[x][y] == 1) {
                            grid[x][y] = 2;
                            q.offer(new int[]{x, y});
                        }
                    }
                }
                step++;
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        return -1;
                    }
                }
            }
            return step == 0 ? 0 : step - 1;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P994RottingOranges().new Solution();
        // put your test code here

    }
}
