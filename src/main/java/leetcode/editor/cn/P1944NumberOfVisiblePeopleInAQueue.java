package leetcode.editor.cn;

import java.util.LinkedList;

public class P1944NumberOfVisiblePeopleInAQueue {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] canSeePersonsCount(int[] heights) {
            int n = heights.length;
            int[] answer = new int[n];
            LinkedList<Integer> stack = new LinkedList<>();
            for (int i = n - 1; i >= 0; i--) {
                int cur = heights[i];
                while (!stack.isEmpty() && cur > stack.peek()) {
                    stack.pop();
                    answer[i]++;
                }
                if (!stack.isEmpty()) {
                    answer[i]++;
                }
                stack.push(cur);
            }
            return answer;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new P1944NumberOfVisiblePeopleInAQueue().new Solution();
        // put your test code here
        
    }
}
