package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class P47PermutationsIi {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();
        boolean[] used;

        public List<List<Integer>> permuteUnique(int[] nums) {
            used = new boolean[nums.length];
            Arrays.sort(nums);
            backtrack(nums);
            return res;
        }

        private void backtrack(int[] nums) {
            if (nums.length == track.size()) {
                res.add(new ArrayList<>(track));
            }
            int preNum = -11;
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) continue;
                if (preNum == nums[i]) continue;
                used[i] = true;
                track.add(nums[i]);
                preNum = nums[i];
                backtrack(nums);
                used[i] = false;
                track.removeLast();
            }
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P47PermutationsIi().new Solution();
        // put your test code here

    }
}
