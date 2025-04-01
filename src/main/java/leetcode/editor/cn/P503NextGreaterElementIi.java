package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.cn.common.*;

public class P503NextGreaterElementIi {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] nextGreaterElements(int[] nums) {
            int n = nums.length;
            Stack<Integer> monotonicStack = new Stack<>();
            int[] res = new int[n];
            for (int i = 2 * n - 1; i >= 0; i--) {
                int num = nums[i % n];
                while (!monotonicStack.isEmpty() && monotonicStack.peek() <= num) {
                    monotonicStack.pop();
                }
                res[i % n] = monotonicStack.isEmpty() ? -1 : monotonicStack.peek();
                monotonicStack.push(num);
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new P503NextGreaterElementIi().new Solution();
        // put your test code here
        
    }
}
