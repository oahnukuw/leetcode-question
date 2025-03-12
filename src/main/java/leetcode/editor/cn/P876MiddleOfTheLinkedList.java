package leetcode.editor.cn;

import leetcode.editor.cn.common.ListNode;

public class P876MiddleOfTheLinkedList {

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
        public ListNode middleNode(ListNode head) {
            ListNode fast = head, slow = head;
//            If wish node stop at the prior one when list length is oven fast move forward one step.
//            fast = fast.next;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P876MiddleOfTheLinkedList().new Solution();
        // put your test code here

    }
}
