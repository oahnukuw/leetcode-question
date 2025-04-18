package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P78Subsets {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res;
        LinkedList<Integer> sub;

        public List<List<Integer>> subsets(int[] nums) {
            res = new ArrayList<>();
            sub = new LinkedList<>();
            int n = nums.length;
            backtrack(nums, 0);
            return res;
        }

        private void backtrack(int[] nums, int start) {
            res.add(new LinkedList<>(sub));
            for (int i = start; i < nums.length; i++) {
                sub.addLast(nums[i]);
                backtrack(nums, i+1);
                sub.removeLast();
            }
        }


    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P78Subsets().new Solution();
        // put your test code here

    }
}
