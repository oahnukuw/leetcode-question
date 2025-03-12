package leetcode.editor.cn;

import leetcode.editor.cn.common.ListNode;

public class P2AddTwoNumbers {

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(-1);
            ListNode p1 = l1, p2 = l2;
            ListNode p = dummy;
            int carry = 0;
            while (p1 != null || p2 != null || carry > 0) {
                int val = carry;
                if (p1 != null) {
                    val += p1.val;
                    p1 = p1.next;
                }
                if (p2 != null) {
                    val += p2.val;
                    p2 = p2.next;
                }
                carry = val / 10;
                val %= 10;
                ListNode node = new ListNode(val);
                p.next = node;
                p = p.next;
            }
            return dummy.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P2AddTwoNumbers().new Solution();
        // put your test code here

    }
}
