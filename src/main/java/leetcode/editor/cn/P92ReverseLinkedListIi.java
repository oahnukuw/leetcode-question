package leetcode.editor.cn;

import leetcode.editor.cn.common.ListNode;

public class P92ReverseLinkedListIi {

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
        public ListNode reverseBetween(ListNode head, int left, int right) {
            if (left == 1) {
                return reverseN(head, right);
            }

            ListNode p = head;
            for (int i = 1; i < left-1; i++) {
                p = p.next;
            }
            ListNode res = reverseN(p.next, right - left + 1);
            p.next = res;
            return head;
        }

        ListNode reverseN(ListNode head, int n) {
            ListNode pre = null, p = head;

            while (n > 0) {
                ListNode node = p;
                p = p.next;
                node.next = pre;
                pre = node;
                n--;
            }
            head.next = p;
            return pre;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new P92ReverseLinkedListIi().new Solution();
        // put your test code here
        
    }
}
