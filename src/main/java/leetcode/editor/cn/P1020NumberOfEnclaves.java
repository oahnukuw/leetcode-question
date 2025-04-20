package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.cn.common.*;

public class P1020NumberOfEnclaves {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int res = 0;
        public int numEnclaves(int[][] grid) {

            int m = grid.length, n = grid[0].length;
            for (int i = 0; i < m; i++) {
                dfs(grid, i, 0, false);
                dfs(grid, i, n - 1, false);
            }
            for (int j = 0; j < n; j++) {
                dfs(grid, 0, j, false);
                dfs(grid, m - 1, j, false);
            }
            for (int i = 0; i < m ; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        dfs(grid, i, j, true);
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
                res++;
            }
            grid[i][j] = 0;
            dfs(grid, i - 1, j, needCount);
            dfs(grid, i + 1, j, needCount);
            dfs(grid, i, j + 1, needCount);
            dfs(grid, i, j - 1, needCount);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new P1020NumberOfEnclaves().new Solution();
        // put your test code here
        
    }
}
