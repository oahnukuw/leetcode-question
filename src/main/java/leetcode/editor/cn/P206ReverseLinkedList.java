package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.cn.common.*;

public class P206ReverseLinkedList {

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
        public ListNode reverseList(ListNode head) {
//            return iterate(head);

            return traverse(head);
        }
        ListNode iterate(ListNode head) {
            ListNode p = head, pre = null;
            while (p != null) {
                ListNode node = p;
                p = p.next;
                node.next = pre;
                pre = node;
            }
            return pre;
        }
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        ListNode traverse(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode last = traverse(head.next);
            head.next.next = head;
            head.next = null;
            return last;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P206ReverseLinkedList().new Solution();
        // put your test code here

    }
}
