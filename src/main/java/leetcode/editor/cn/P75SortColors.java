package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.cn.common.*;

public class P75SortColors {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void sortColors(int[] nums) {
            int slow = 0, fast = 0;
            while (fast < nums.length) {
                if (nums[fast] == 0) {
                    int temp = nums[slow];
                    nums[slow] = nums[fast];
                    nums[fast] = temp;
                    slow++;
                }
                fast++;
            }
            fast=slow;
            while (fast < nums.length) {
                if (nums[fast] == 1) {
                    int temp = nums[slow];
                    nums[slow] = nums[fast];
                    nums[fast] = temp;
                    slow++;
                }
                fast++;
            }
            
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new P75SortColors().new Solution();
        // put your test code here
        
    }
}
