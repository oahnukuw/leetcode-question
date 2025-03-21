package leetcode.editor.cn;

import java.util.TreeSet;

public class P220ContainsDuplicateIii {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
            // Maintain a window that holds elements between [l,r), which as for the new element nums[r] can get the element of the window which is the closest to nums[r]. So using a Treeset as a window that can get the ceiling element or the floor element to compare with valueDiff.
            TreeSet<Integer> window = new TreeSet<>();
            int l = 0, r = 0;
            while (r < nums.length) {
                Integer ceiling = window.ceiling(nums[r]);
                if (ceiling != null && Math.abs(nums[r] - ceiling) <= valueDiff) {
                    return true;
                }
                Integer floor = window.floor(nums[r]);
                if (floor != null && Math.abs(nums[r] - floor) <= valueDiff) {
                    return true;
                }
                window.add(nums[r]);
                r++;
                if ((r - l) > indexDiff) {
                    window.remove(nums[l]);
                    l++;
                }
            }
            return false;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P220ContainsDuplicateIii().new Solution();
        // put your test code here

    }
}
