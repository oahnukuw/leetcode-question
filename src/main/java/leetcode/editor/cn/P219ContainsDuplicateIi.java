package leetcode.editor.cn;

import java.util.HashSet;

public class P219ContainsDuplicateIi {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            int left = 0, right = 0;
            HashSet<Integer> window = new HashSet<>();
            while (right < nums.length) {
                if (window.contains(nums[right])) {
                    return true;
                }
                window.add(nums[right++]);

                if (right - left > k) {
                    window.remove(nums[left++]);
                }
            }
            return false;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P219ContainsDuplicateIi().new Solution();
        // put your test code here

    }
}
