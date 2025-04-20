package leetcode.editor.cn;


public class P695MaxAreaOfIsland {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int area = 0;

        public int maxAreaOfIsland(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            int res = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        dfs(grid, i, j, true);
                        res = Math.max(area, res);
                        area = 0;
                    }
                }
            }
            return res;
        }

        private void dfs(int[][] grid, int i, int j, boolean needCount) {
            int m = grid.length, n = grid[0].length;
            if (i < 0 || i >= m || j < 0 || j >= n) {
                return;
            }
            if (grid[i][j] == 0) {
                return;
            }
            if (needCount) {
                area++;
            }
            grid[i][j] = 0;
            dfs(grid, i - 1, j, needCount);
            dfs(grid, i + 1, j, needCount);
            dfs(grid, i, j + 1, needCount);
            dfs(grid, i, j - 1, needCount);
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P695MaxAreaOfIsland().new Solution();
        // put your test code here

    }
}
