package leetcode.editor.cn;

public class P1004MaxConsecutiveOnesIii {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestOnes(int[] nums, int k) {
            // Maintain a window that holds the count of one (including k 0)
            // k = (right - left - oneCount);
            int l = 0, r = 0;
            int oneCount = 0;
            int res = 0;
            while (r < nums.length) {
                if (nums[r] == 1) {
                    oneCount++;
                }
                r++;
                while (r - l - oneCount > k) {
                    if (nums[l] == 1) {
                        oneCount--;
                    }
                    l++;
                }
                res = Math.max(res, r - l);
            }

            return res;

        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P1004MaxConsecutiveOnesIii().new Solution();
        // put your test code here

    }
}
