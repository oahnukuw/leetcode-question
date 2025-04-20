package leetcode.editor.cn;

public class P1905CountSubIslands {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countSubIslands(int[][] grid1, int[][] grid2) {
            int m = grid2.length, n = grid2[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid2[i][j] == 1 && grid1[i][j] == 0) {
                        dfs(grid2, i, j);
                    }
                }
            }
            int res = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid2[i][j] == 1) {
                        res++;
                        dfs(grid2, i, j);
                    }
                }
            }
            return res;
        }

        private void dfs(int[][] grid2, int i, int j) {
            int m = grid2.length, n = grid2[0].length;
            if (i < 0 || j < 0 || i >= m || j >= n) {
                return;
            }
            if (grid2[i][j] == 0) {
                return;
            }
            grid2[i][j] = 0;

            dfs(grid2, i - 1, j);
            dfs(grid2, i + 1, j);
            dfs(grid2, i, j - 1);
            dfs(grid2, i, j + 1);
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P1905CountSubIslands().new Solution();
        // put your test code here

    }
}
