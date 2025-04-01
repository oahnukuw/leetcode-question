package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.cn.common.*;

public class P496NextGreaterElementI {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            Map<Integer, Integer> valToIndex = new HashMap<>(nums1.length);
            for (int i = 0; i < nums1.length; i++) {
                valToIndex.put(nums1[i], i);
            }
            Stack<Integer> monotonicStack = new Stack<>();
            int[] res = new int[nums1.length];
            for (int i = nums2.length-1; i >=0 ; i--) {
                int val = nums2[i];
                while (!monotonicStack.isEmpty() && monotonicStack.peek() <= val) {
                    monotonicStack.pop();
                }
                Integer index = valToIndex.get(val);
                if (index != null) {
                    res[index] = monotonicStack.isEmpty() ? -1 : monotonicStack.peek();
                }
                monotonicStack.push(val);
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
