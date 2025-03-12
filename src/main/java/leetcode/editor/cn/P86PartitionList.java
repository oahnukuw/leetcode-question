package leetcode.editor.cn;

import leetcode.editor.cn.common.ListNode;

public class P86PartitionList {

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
        public ListNode partition(ListNode head, int x) {
            ListNode dummy1 = new ListNode(-1), dummy2 = new ListNode(-1);
            ListNode p1 = dummy1, p2 = dummy2, p = head;
            while (p != null) {
                if (p.val < x) {
                    p1.next = p;
                    p1 = p1.next;
                } else {
                    p2.next=p;
                    p2 = p2.next;
                }
                ListNode temp = p;
                p = p.next;
                temp.next = null;
            }
            p1.next = dummy2.next;
            return dummy1.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P86PartitionList().new Solution();
        // put your test code here

    }
}
