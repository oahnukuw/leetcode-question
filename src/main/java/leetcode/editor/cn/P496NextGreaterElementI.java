package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.cn.common.*;

public class P496NextGreaterElementI {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            HashMap<Integer, Integer> numToIndex = new HashMap<>();
            Deque<Integer> monotonicStack = new LinkedList<>();
            int[] nextBigger = new int[nums2.length];
            for (int i = nums2.length-1; i >=0; i--) {
                int cur = nums2[i];
                numToIndex.put(cur, i);
                while (!monotonicStack.isEmpty() && cur >= monotonicStack.peek()) {
                    monotonicStack.pop();
                }
                if (!monotonicStack.isEmpty()) {
                    nextBigger[i] = monotonicStack.peek();
                } else {
                    nextBigger[i] = -1;
                }
                monotonicStack.push(cur);
            }
            int[] res = new int[nums1.length];
            for (int i = 0; i < nums1.length; i++) {
                int e = nums1[i];
                Integer index = numToIndex.get(e);
                res[i] = nextBigger[index];
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new P496NextGreaterElementI().new Solution();
        // put your test code here
        
    }
}
