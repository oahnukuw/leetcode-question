package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class P1926NearestExitFromEntranceInMaze {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

        public int nearestExit(char[][] maze, int[] entrance) {
            int m = maze.length, n = maze[0].length;
            boolean[][] visited = new boolean[m][n];
            Queue<int[]> q = new ArrayDeque<>();
            q.offer(entrance);
            visited[entrance[0]][entrance[1]] = true;
            int step = 0;
            while (!q.isEmpty()) {
                int size = q.size();
                step++;
                for (int i = 0; i < size; i++) {
                    int[] cur = q.poll();
                    for (int[] dir : dirs) {
                        int x = cur[0] + dir[0];
                        int y = cur[1] + dir[1];
                        if (x < 0 || x >= m || y < 0 || y >= n || maze[x][y] == '+' || visited[x][y]) {
                            continue;
                        }
                        if ((x == 0 || y == 0 || x == m - 1 || y == n - 1)) {
                            return step;
                        }
                        q.offer(new int[]{x, y});
                        visited[x][y] = true;
                    }
                }
            }
            return -1;
        }


        private List<int[]> getNeighbors(int[] cur, char[][] maze) {
            int m = maze.length, n = maze[0].length;
            ArrayList<int[]> neighbors = new ArrayList<>();
            return neighbors;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P1926NearestExitFromEntranceInMaze().new Solution();
        // put your test code here

    }
}
