package leetcode.editor.cn;

import leetcode.editor.cn.common.ListNode;

public class P21MergeTwoSortedLists {

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
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode dummy = new ListNode(-1);
            ListNode p = dummy;
            ListNode p1 = list1;
            ListNode p2 = list2;

            while (p1 != null && p2 != null) {
                if (p1.val <= p2.val) {
                    p.next = p1;
                    p1 = p1.next;
                } else {
                    p.next = p2;
                    p2 = p2.next;
                }
                p = p.next;
            }

            if (p1 != null) {
                p.next = p1;
            }
            if (p2 != null) {
                p.next = p2;
            }
            return dummy.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P21MergeTwoSortedLists().new Solution();
        // put your test code here
        ListNode listNode21 = new ListNode(1, new ListNode(2));
        ListNode listNode12 = new ListNode(1, new ListNode(2));

        ListNode listNode = solution.mergeTwoLists(listNode12, listNode21);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
