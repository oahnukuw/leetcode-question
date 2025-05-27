package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class P491NonDecreasingSubsequences {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<List<Integer>> res;
        LinkedList<Integer> track;
        public List<List<Integer>> findSubsequences(int[] nums) {
            // Repeated Number Select Once
            res = new ArrayList<>();
            track = new LinkedList<>();
            backtrack(nums, 0);
            return res;
        }

        private void backtrack(int[] nums, int start) {
            if (track.size() >= 2) {
                res.add(new ArrayList<>(track));
            }
            HashSet<Integer> used = new HashSet<>();
            for (int i = start; i < nums.length; i++) {
                int cur = nums[i];
                if (used.contains(cur)) {
                    continue;
                }
                if (!track.isEmpty() && track.getLast() > cur) {
                    continue;
                }
                used.add(cur);
                track.addLast(cur);
                backtrack(nums, i + 1);
                track.removeLast();
            }
        }

    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P491NonDecreasingSubsequences().new Solution();
        // put your test code here

    }
}
