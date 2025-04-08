package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.cn.common.*;

public class P96UniqueBinarySearchTrees {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] memo;
        public int numTrees(int n) {
            memo = new int[n + 1][n + 1];
            return count(1, n);
        }

        // Define: return [ lo,hi ] count of BST
        int count(int lo, int hi) {
            if (lo > hi) return 1;
            if (memo[lo][hi] != 0) {
                return memo[lo][hi];
            }
            int res = 0;
            for (int i = lo; i <= hi; i++) {
                int left = count(lo, i - 1);
                int right = count(i+1, hi);
                res += left * right;
            }
            memo[lo][hi] = res;
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new P96UniqueBinarySearchTrees().new Solution();
        // put your test code here
        
    }
}
