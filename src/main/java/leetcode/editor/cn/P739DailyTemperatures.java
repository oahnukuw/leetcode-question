package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.cn.common.*;

public class P739DailyTemperatures {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            Stack<Integer> monotonicStack = new Stack<>();
            int[] res = new int[temperatures.length];
            for (int i = temperatures.length - 1; i >= 0; i--) {
                int temperature = temperatures[i];
                while (!monotonicStack.isEmpty() && temperatures[monotonicStack.peek()] <= temperature) {
                    monotonicStack.pop();
                }
                res[i] = monotonicStack.isEmpty() ? 0 : monotonicStack.peek() - i;
                monotonicStack.push(i);
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new P739DailyTemperatures().new Solution();
        // put your test code here
        
    }
}
