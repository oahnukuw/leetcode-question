package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.cn.common.*;

public class P48RotateImage {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void rotate(int[][] matrix) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = i; j < matrix[i].length; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
            for (int i = 0; i < matrix.length; i++) {
                int l = 0, r = matrix.length - 1;
                while (l < r) {
                    int temp = matrix[i][l];
                    matrix[i][l] = matrix[i][r];
                    matrix[i][r] = temp;
                    l++;
                    r--;
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new P48RotateImage().new Solution();
        // put your test code here
        
    }
}
