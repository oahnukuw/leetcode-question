package leetcode.editor.cn;

public class P59SpiralMatrixIi {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] generateMatrix(int n) {
            int leftBounder = 0, topBounder = 0;
            int bottomBounder = n - 1, rightBounder = n - 1;
            int[][] matrix = new int[n][n];
            int element = 1;
            while (element <= n * n) {
                // From the left to the right in the top
                if (topBounder <= bottomBounder) {
                    for (int j = leftBounder; j <= rightBounder; j++) {
                        matrix[topBounder][j] = element;
                        element++;
                    }
                    topBounder++;
                }
                // From the top to the bottom in the right
                if (leftBounder <= rightBounder) {
                    for (int i = topBounder; i <= bottomBounder; i++) {
                        matrix[i][rightBounder] = element;
                        element++;
                    }
                    rightBounder--;
                }
                // From the right to the left in the bottom
                if (topBounder <= bottomBounder) {
                    for (int j = rightBounder; j >= leftBounder; j--) {
                        matrix[bottomBounder][j] = element;
                        element++;
                    }
                    bottomBounder--;
                }
                // From the bottom to the top in the left
                if (leftBounder <= rightBounder) {
                    for (int i = bottomBounder; i >= topBounder; i--) {
                        matrix[i][leftBounder] = element;
                        element++;
                    }
                    leftBounder++;
                }
            }
            return matrix;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new P59SpiralMatrixIi().new Solution();
        // put your test code here
        
    }
}
