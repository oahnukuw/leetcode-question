package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.cn.common.*;

public class P1944NumberOfVisiblePeopleInAQueue {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] canSeePersonsCount(int[] heights) {
            int n = heights.length;
            Stack<Integer> s = new Stack<>();
            int[] res = new int[n];
            for (int i = n-1; i >= 0; i--) {
                int height = heights[i];
                res[i] = 0;
                while (!s.isEmpty() && s.peek() < height) {
                    s.pop();
                    res[i]++;
                }
                res[i] = s.isEmpty() ? res[i] : res[i] + 1;
                s.push(height);
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new P1944NumberOfVisiblePeopleInAQueue().new Solution();
        // put your test code here
        
    }
}
