package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.cn.common.*;

public class P25ReverseNodesInKGroup {

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode p = head;
            for (int i = 0; i < k; i++) {
                if (p == null) {
                    return head;
                }
                p = p.next;
            }

            ListNode last = reverseKGroup(p, k);
            ListNode pre = null, q = head;
            while (k-- > 0) {
                ListNode nextToReverse = q.next;
                q.next = pre;
                pre = q;
                q = nextToReverse;
            }
            head.next = last;
            return pre;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new P25ReverseNodesInKGroup().new Solution();
        // put your test code here
        
    }
}
