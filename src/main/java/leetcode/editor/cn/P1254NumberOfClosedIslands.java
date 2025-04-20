package leetcode.editor.cn;

public class P1254NumberOfClosedIslands {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int closedIsland(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            for (int i = 0; i < m; i++) {
                // Fill the left edge 
                dfsFill(grid, i, 0);
                // Fill the right edge 
                dfsFill(grid, i, n - 1);
            }
            for (int j = 0; j < n; j++) {
                // Fill the up edge 
                dfsFill(grid, 0, j);
                // Fill the bottom edge 
                dfsFill(grid, m - 1, j);
            }
            int res = 0;
            for (int i = 1; i < m - 1; i++) {
                for (int j = 1; j < n - 1; j++) {
                    if (grid[i][j] == 0) {
                        res++;
                        dfsFill(grid, i, j);
                    }
                }
            }

            return res;
        }

        private void dfsFill(int[][] grid, int i, int j) {
            int m = grid.length, n = grid[0].length;
            if (i < 0 || j < 0 || i >= m || j >= n) {
                return;
            }
            if (grid[i][j] == 1) {
                return;
            }
            grid[i][j] = 1;
            dfsFill(grid, i - 1, j);
            dfsFill(grid, i + 1, j);
            dfsFill(grid, i, j - 1);
            dfsFill(grid, i, j + 1);
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P1254NumberOfClosedIslands().new Solution();
        // put your test code here

    }
}
