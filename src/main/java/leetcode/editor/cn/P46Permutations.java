package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P46Permutations {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res;
        LinkedList<Integer> track;
        boolean[] visited;
        public List<List<Integer>> permute(int[] nums) {
            res = new ArrayList<>();
            track = new LinkedList<>();
            visited = new boolean[nums.length];
            backtrack(nums);
            return res;
        }

        private void backtrack(int[] nums) {
            if (track.size() == nums.length) {
                res.add(new ArrayList<>(track));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (visited[i]) continue;
                visited[i] = true;
                track.addLast(nums[i]);
                backtrack(nums);
                track.removeLast();
                visited[i] = false;
            }
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P46Permutations().new Solution();
        // put your test code here

    }
}
