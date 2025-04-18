package leetcode.editor.cn;

import java.util.*;

public class P40CombinationSumIi {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();
        int trackSum = 0;

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            backtrack(candidates, target, 0);
            return res;
        }

        private void backtrack(int[] candidates, int target, int start) {
            if (trackSum == target) {
                res.add(new ArrayList<>(track));
                return;
            }
            if (trackSum > target) {
                return;
            }

            for (int i = start; i < candidates.length; i++) {
                if (i > start && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                trackSum += candidates[i];
                track.addLast(candidates[i]);
                backtrack(candidates, target, i + 1);
                trackSum -= candidates[i];
                track.removeLast();
            }
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P40CombinationSumIi().new Solution();
        // put your test code here

    }
}
