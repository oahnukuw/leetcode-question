package leetcode.editor.cn;

public class P34FindFirstAndLastPositionOfElementInSortedArray {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int start = searchLeftBounder(nums, target);
            int end = searchRightBounder(nums, target);
            return new int[]{start, end};
        }

        private int searchLeftBounder(int[] nums, int target) {
            int left = 0, right = nums.length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] >= target) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            if (left >= nums.length) {
                return -1;
            }
            return nums[left] == target ? left : -1;
        }

        private int searchRightBounder(int[] nums, int target) {
            int left = 0, right = nums.length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] <= target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if (left - 1 < 0 || left - 1 >= nums.length) {
                return -1;
            }
            return nums[left - 1] == target ? (left - 1) : -1;

        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P34FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        // put your test code here
        int[] ints = {5, 7, 7, 8, 8, 10};
        solution.searchRange(ints, 8);

    }
}
