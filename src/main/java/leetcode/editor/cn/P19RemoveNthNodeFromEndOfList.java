package leetcode.editor.cn;

import leetcode.editor.cn.common.ListNode;

public class P19RemoveNthNodeFromEndOfList {

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
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode p = head;
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode p1 = dummy, p2 = dummy;
            // With dummy head, the distance of the Nth from end node to the null doesn't change. The steps from the first node to the Nthfromend node are calculated by the steps from first node to the null - the steps of the Nthfromend node to the null.
            for (int i = 0; i < n + 1; i++) {
                p1 = p1.next;
            }
            while (p1 != null) {
                p1 = p1.next;
                p2 = p2.next;
            }
            ListNode node = p2.next;
            p2.next = node.next;
            node.next = null;
            return dummy.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P19RemoveNthNodeFromEndOfList().new Solution();
        // put your test code here

    }
}
