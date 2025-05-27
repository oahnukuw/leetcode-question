package leetcode.editor.cn;

public class P980UniquePathsIii {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        boolean[][] visited;
        int res = 0;
        int totalCount = 0;
        int trackCount = 0;

        public int uniquePathsIII(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            visited = new boolean[m][n];
            int startI = 0, startJ = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int num = grid[i][j];
                    if (num == 0 || num == 1) {
                        totalCount++;
                    }
                    if (num == 1) {
                        startI = i;
                        startJ = j;
                    }
                }
            }
            dfs(grid, startI, startJ);
            return res;
        }

        private void dfs(int[][] grid, int i, int j) {
            if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length ) {
                return;
            }
            if (visited[i][j] || grid[i][j] == -1) {
                return;
            }
            if (grid[i][j] == 2) {
                if (trackCount == totalCount) {
                    res++;
                }
                return;
            }
            trackCount++;
            visited[i][j] = true;
            dfs(grid, i - 1, j);
            dfs(grid, i + 1, j);
            dfs(grid, i, j - 1);
            dfs(grid, i, j + 1);
            visited[i][j] = false;
            trackCount--;

        }

    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P980UniquePathsIii().new Solution();
        // put your test code here

    }
}
