package leetcode.editor.cn;

import java.util.HashSet;

public class P219ContainsDuplicateIi {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            int l = 0, r = 0;
            HashSet<Integer> window = new HashSet<>();
            while (r < nums.length) {
                // Whether window has two same elements
                if (window.contains(nums[r])) {
                    return true;
                }
                window.add(nums[r]);
                r++;

                if (r - l > k) {
                    window.remove(nums[l]);
                    l++;
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
