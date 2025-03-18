package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

public class P54SpiralMatrix {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            int topBounder = 0, bottomBounder = m - 1;
            int leftBounder = 0, rightBounder = n - 1;
            List<Integer> res = new LinkedList<>();

            while (res.size() < m * n) {
//                from left to the right in the top
                if (topBounder <= bottomBounder) {
                    for (int i = leftBounder; i <= rightBounder; i++) {
                        res.add(matrix[topBounder][i]);
                    }
                    topBounder++;
                }
//                from top to the bottom in the right
                if (leftBounder <= rightBounder) {
                    for (int i = topBounder; i <= bottomBounder; i++) {
                        res.add(matrix[i][rightBounder]);
                    }
                    rightBounder--;
                }
//                from right to left in the bottom
                if (topBounder <= bottomBounder) {
                    for (int i = rightBounder; i >= leftBounder; i--) {
                        res.add(matrix[bottomBounder][i]);
                    }
                    bottomBounder--;
                }
//                from bottom to the top in the left
                if (leftBounder <= rightBounder) {
                    for (int i = bottomBounder; i >= topBounder; i--) {
                        res.add(matrix[i][leftBounder]);
                    }
                    leftBounder++;
                }
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new P54SpiralMatrix().new Solution();
        // put your test code here
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        solution.spiralOrder(matrix);
    }
}
