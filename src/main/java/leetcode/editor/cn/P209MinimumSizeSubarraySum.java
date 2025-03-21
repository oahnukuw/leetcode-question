package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.cn.common.*;

public class P209MinimumSizeSubarraySum {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int l = 0, r = 0;
            int sum = 0;
            int minLen = Integer.MAX_VALUE;
            while (r < nums.length) {
                sum += nums[r];
                r++;
                while (sum >= target) {
                    minLen = Math.min(minLen, r - l);
                    sum -= nums[l];
                    l++;
                }
            }
            return minLen == Integer.MAX_VALUE ? 0 : minLen;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new P209MinimumSizeSubarraySum().new Solution();
        // put your test code here
        
    }
}
