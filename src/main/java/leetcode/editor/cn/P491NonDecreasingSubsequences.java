package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class P491NonDecreasingSubsequences {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();

        public List<List<Integer>> findSubsequences(int[] nums) {
            backtrack(nums, 0);
            return res;
        }

        private void backtrack(int[] nums, int start) {
            if (track.size() > 1) {
                res.add(new ArrayList<>(track));
            }
            HashSet<Integer> levelUsed = new HashSet<>();
            for (int i = start; i < nums.length; i++) {
                if (levelUsed.contains(nums[i])) {
                    continue;
                }
                if (!track.isEmpty() && track.getLast() > nums[i]) {
                    continue;
                }
                levelUsed.add(nums[i]);
                track.add(nums[i]);
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
