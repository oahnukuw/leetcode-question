package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.cn.common.*;

public class P445AddTwoNumbersIi {

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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode p1 = l1, p2 = l2;
            ListNode dummy = new ListNode(-1);
            ListNode p = dummy;
            Stack<Integer> stack1 = new Stack<>();
            Stack<Integer> stack2 = new Stack<>();
            while (p1 != null) {
                stack1.push(p1.val);
                p1 = p1.next;
            }
            while (p2 != null) {
                stack2.push(p2.val);
                p2 = p2.next;
            }
            int carry = 0;
            while (!stack1.isEmpty() || !stack2.isEmpty() || carry > 0) {
                int val = carry;
                if (!stack1.isEmpty()) {
                    val += stack1.pop();
                }
                if (!stack2.isEmpty()) {
                    val += stack2.pop();
                }
                carry = val / 10;
                val %= 10;
                ListNode listNode = new ListNode(val);
                listNode.next = dummy.next;
                dummy.next = listNode;
            }
            return dummy.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new P445AddTwoNumbersIi().new Solution();
        // put your test code here
        
    }
}
