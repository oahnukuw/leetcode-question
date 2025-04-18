package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P39CombinationSum {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();
        int trackSum = 0;

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            backtrack(candidates, target, 0);
            return res;
        }

        private void backtrack(int[] candidates, int target, int start) {
            if (trackSum == target) {
                res.add(new ArrayList<>(track));
                return;
            }
            if (trackSum > target) return;

            for (int i = start; i < candidates.length; i++) {
                trackSum += candidates[i];
                track.add(candidates[i]);
                backtrack(candidates, target, i);
                trackSum -= candidates[i];
                track.removeLast();
            }
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P39CombinationSum().new Solution();
        // put your test code here

    }
}
