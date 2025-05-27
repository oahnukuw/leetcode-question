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
//            1. Get the middle node using fast and slow pointer scanning
            ListNode fast = head, slow = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
//            2. Now slow is the head of the last half nodes
//            Reverse the last half nodes
            ListNode pre = null, p = slow;
            while (p != null) {
                ListNode next = p.next;
                p.next = pre;
                pre = p;
                p = next;
            }
            left = head;
            right = pre;
            while (right != null) {
                if (left.val != right.val) {
                    return false;
                }
                left = left.next;
                right = right.next;
            }
            return true;
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
