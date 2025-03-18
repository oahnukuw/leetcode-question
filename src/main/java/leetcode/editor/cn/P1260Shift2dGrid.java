package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class P1260Shift2dGrid {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> shiftGrid(int[][] grid, int k) {
            int m = grid.length, n = grid[0].length;
            int realK = k % (m * n);
            reverseN(grid, (m * n) - realK, (m * n) - 1);
            reverseN(grid, 0, (m * n) - realK - 1);
            reverseN(grid, 0, (m * n) - 1);
            List<List<Integer>> res = new ArrayList<>();
            int index = 0;
            for (int i = 0; i < m; i++) {
                ArrayList<Integer> array = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    array.add(get(grid, index++));
                }
                res.add(array);
            }
            return res;
        }

        int get(int[][] grid, int index) {
            int n = grid[0].length;
            int i = index / n, j = index % n;
            return grid[i][j];
        }

        void set(int[][] grid, int index, int value) {
            int n = grid[0].length;
            int i = index / n, j = index % n;
            grid[i][j] = value;
        }

        void reverseN(int[][] grid, int l, int r) {

            while (l < r) {
                int temp = get(grid, l);
                set(grid, l, get(grid, r));
                set(grid, r, temp);
                l++;
                r--;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new P1260Shift2dGrid().new Solution();
        // put your test code here
        int[][] grid = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        solution.shiftGrid(grid, 1);

    }
}
