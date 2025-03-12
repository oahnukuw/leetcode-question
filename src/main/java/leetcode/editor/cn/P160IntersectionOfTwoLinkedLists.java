package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.cn.common.*;

public class P160IntersectionOfTwoLinkedLists {

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode p1 = headA, p2 = headB;
            while (p1 != p2) {
                if (p1 == null) {
                    p1 = headB;
                } else {
                    p1 = p1.next;
                }
                if (p2 == null) {
                    p2 = headA;
                } else {
                    p2 = p2.next;
                }
            }
            return p1;
            
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new P160IntersectionOfTwoLinkedLists().new Solution();
        // put your test code here
        
    }
}
