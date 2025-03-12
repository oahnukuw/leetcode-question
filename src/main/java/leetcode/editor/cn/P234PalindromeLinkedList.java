package leetcode.editor.cn;

import leetcode.editor.cn.common.ListNode;

public class P234PalindromeLinkedList {

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

        ListNode left, right;
        boolean res = true;

        public boolean isPalindrome(ListNode head) {
//            left = head;
//            traverse(head);
//            return res;
            ListNode slow, fast;

            slow = fast = head;
            ListNode pre = null;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                ListNode node = slow;
                slow = slow.next;
                node.next = pre;
                pre = node;
            }
            if (fast != null) {
                slow = slow.next;
            }
            ListNode p = pre;
            boolean res = true;
            while (p != null && slow != null) {
                if (p.val != slow.val) {
                    return false;
                }
                p = p.next;
                slow = slow.next;
            }
            return res;
        }

        private void traverse(ListNode right) {
            if (right == null) {
                return;
            }
            traverse(right.next);
            if (right.val != left.val) {
                res = false;
            }
            left = left.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new P234PalindromeLinkedList().new Solution();
        // put your test code here
        
    }
}
