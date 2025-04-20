package leetcode.editor.cn;

public class P200NumberOfIslands {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numIslands(char[][] grid) {
            int m = grid.length, n = grid[0].length;
            int res = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        res++;
                        dfsFill(grid, i, j);
                    }
                }
            }
            return res;
        }

        private void dfsFill(char[][] grid, int i, int j) {
            int m = grid.length, n = grid[0].length;
            if (i >= m || j >= n || i < 0 || j < 0) return;
            if (grid[i][j] == '0') return;
            grid[i][j] = '0';
            dfsFill(grid, i - 1, j);
            dfsFill(grid, i + 1, j);
            dfsFill(grid, i, j - 1);
            dfsFill(grid, i, j + 1);
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P200NumberOfIslands().new Solution();
        // put your test code here

    }
}
