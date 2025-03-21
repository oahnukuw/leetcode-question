package leetcode.editor.cn;

public class P713SubarrayProductLessThanK {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            int l = 0, r = 0;
            int res = 0;
            int windowProduct = 1;
            while (r < nums.length) {
                windowProduct *= nums[r];
                r++;
                while (windowProduct >= k && l < r) {
                    windowProduct /= nums[l];
                    l++;
                }
                res += r - l;
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P713SubarrayProductLessThanK().new Solution();
        // put your test code here

    }
}
