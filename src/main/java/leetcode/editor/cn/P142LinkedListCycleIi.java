package leetcode.editor.cn;

import leetcode.editor.cn.common.ListNode;

public class P142LinkedListCycleIi {

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            ListNode fast = head, slow = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (fast == slow) {
                    break;
                }
            }
            if (fast == null || fast.next == null) {
                return null;
            }
            slow=head;
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow;

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P142LinkedListCycleIi().new Solution();
        // put your test code here

    }
}
