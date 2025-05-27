package leetcode.editor.cn;

import java.util.TreeSet;

public class P220ContainsDuplicateIii {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
            int left = 0, right = 0;
            TreeSet<Integer> window = new TreeSet<>();
            while (right < nums.length) {
                int num = nums[right++];
                Integer floor = window.floor(num);
                Integer ceiling = window.ceiling(num);
                if (floor!=null&&Math.abs(floor - num) <= valueDiff) {
                    return true;
                }
                if (ceiling != null && Math.abs(ceiling - num) <= valueDiff) {
                    return true;
                }
                window.add(num);
                if (right - left > indexDiff) {
                    window.remove(nums[left++]);
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
