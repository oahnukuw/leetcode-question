package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class P1091ShortestPathInBinaryMatrix {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] dirs = new int[][]{
                {0, 1},
                {0, -1},
                {-1, 0},
                {1, 0},
                {1, 1},
                {1, -1},
                {-1, 1},
                {-1, -1},
        };

        public int shortestPathBinaryMatrix(int[][] grid) {
            int n = grid.length;
            if (grid[0][0] == 1) {
                return -1;
            }
            boolean[][] visited = new boolean[n][n];
            Queue<int[]> q = new LinkedList<>();
            int[] target = new int[]{n - 1, n - 1};
            q.offer(new int[]{0, 0});
            visited[0][0] = true;
            int step = 1;
            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    int[] cur = q.poll();
                    if (cur[0] == target[0] && cur[1] == target[1]) {
                        return step;
                    }
                    for (int[] dir : dirs) {
                        int x = cur[0] + dir[0], y = cur[1] + dir[1];
                        if (x < 0 || x >= n || y < 0 || y >= n || visited[x][y] || grid[x][y] == 1) {
                            continue;
                        }
                        q.offer(new int[]{x, y});
                        visited[x][y] = true;
                    }
                }
                step++;
            }
            return -1;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P1091ShortestPathInBinaryMatrix().new Solution();
        // put your test code here

    }
}
