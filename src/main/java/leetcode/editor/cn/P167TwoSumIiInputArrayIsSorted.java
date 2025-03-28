package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.cn.common.*;

public class P167TwoSumIiInputArrayIsSorted {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int left = 0, right = numbers.length-1;
            while (left < right) {
                int sum = numbers[left] + numbers[right];
                if (sum == target) {
                    return new int[]{left + 1, right + 1};
                } else if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                }
            }
            return new int[]{-1, -1};
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new P167TwoSumIiInputArrayIsSorted().new Solution();
        // put your test code here
        
    }
}
