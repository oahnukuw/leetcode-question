package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P216CombinationSumIii {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();
        int trackSum = 0;

        public List<List<Integer>> combinationSum3(int k, int n) {
            backtrack(k, n, 1);
            return res;
        }

        private void backtrack(int k, int n, int start) {
            if (trackSum == n && track.size()==k) {
                res.add(new ArrayList<>(track));
                return;
            }
            if (trackSum > n || track.size() > k) {
                return;
            }
            for (int i = start; i <=9; i++) {
                track.addLast(i);
                trackSum += i;
                backtrack(k, n, i + 1);
                track.removeLast();
                trackSum -= i;
            }
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P216CombinationSumIii().new Solution();
        // put your test code here

    }
}
