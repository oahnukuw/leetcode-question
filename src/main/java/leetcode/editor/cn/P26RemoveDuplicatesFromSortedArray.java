package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.cn.common.*;

public class P26RemoveDuplicatesFromSortedArray {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums.length == 0) return 0;

            int fast = 0, slow = 0;

            while (fast < nums.length) {
                if (nums[fast] != nums[slow]) {
                    slow++;
                    nums[slow] = nums[fast];
                }
                fast++;
            }
            return slow + 1;
            
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new P26RemoveDuplicatesFromSortedArray().new Solution();
        // put your test code here
        
    }
}
