package leetcode.editor.cn;

public class P410SplitArrayLargestSum {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int splitArray(int[] nums, int k) {
            int left = 0, right = 1;
            for (int num : nums) {
                left = Math.max(num, left);
                right += num;
            }
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (f(nums, mid) <= k) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }

        private int f(int[] nums, int sum) {
            int days = 0;
            for (int i = 0; i < nums.length; ) {
                int cap = sum;
                while (i < nums.length) {
                    if (nums[i] > cap) {
                        break;
                    } else {
                        cap -= nums[i];
                    }
                    i++;
                }
                days++;
            }
            return days;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new P410SplitArrayLargestSum().new Solution();
        // put your test code here
        
    }
}
