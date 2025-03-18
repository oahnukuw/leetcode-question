package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class P1329SortTheMatrixDiagonally {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] diagonalSort(int[][] mat) {
            int m = mat.length, n = mat[0].length;
            HashMap<Integer, ArrayList<Integer>> diagonals = new HashMap<>();

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int diagonalId = i - j;
                    diagonals.putIfAbsent(diagonalId, new ArrayList<Integer>());
                    diagonals.get(diagonalId).add(mat[i][j]);
                }
            }

            diagonals.forEach((k, v) -> Collections.sort(v, Collections.reverseOrder()));

            int[][] res = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    ArrayList<Integer> diagnoal = diagonals.get(i - j);
                    res[i][j] = diagnoal.remove(diagnoal.size() - 1);
                }
            }
            return res;
            
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new P1329SortTheMatrixDiagonally().new Solution();
        // put your test code here
        
    }
}
