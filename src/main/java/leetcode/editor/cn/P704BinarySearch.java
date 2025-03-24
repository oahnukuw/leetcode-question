package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.cn.common.*;

public class P704BinarySearch {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            int l = 0, r = nums.length;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] > target) {
                    r = mid;
                } else if (nums[mid] < target) {
                    l = mid + 1;
                }
            }
            return -1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new P704BinarySearch().new Solution();
        // put your test code here
        
    }
}
