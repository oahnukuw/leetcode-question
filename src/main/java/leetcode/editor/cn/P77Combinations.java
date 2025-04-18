package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P77Combinations {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res;
        LinkedList<Integer> sub;

        public List<List<Integer>> combine(int n, int k) {
            res = new ArrayList<>();
            sub = new LinkedList<>();
            backtrack(1, k, n);
            return res;
        }

        private void backtrack(int start, int k, int n) {
            if (sub.size() == k) {
                res.add(new ArrayList<>(sub));
                return;
            }

            // Loop means the arrangement of Choices
            for (int i = start; i <= n; i++) {
                // Now you are in the branch
                sub.addLast(i);
                backtrack(i + 1, k, n);
                sub.removeLast();
            }
        }


    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P77Combinations().new Solution();
        // put your test code here

    }
}
