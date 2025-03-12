package leetcode.editor.cn;

import leetcode.editor.cn.common.ListNode;

public class P82RemoveDuplicatesFromSortedListIi {

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
        public ListNode deleteDuplicates(ListNode head) {
            ListNode dummyDup = new ListNode(101);
            ListNode dummyUni = new ListNode(101);
            ListNode p = head, pDup = dummyDup, pUni = dummyUni;
            while (p != null) {
                if ((p.next != null && p.val == p.next.val) || p.val == pDup.val) {
                    pDup.next = p;
                    pDup = pDup.next;
                } else {
                    pUni.next = p;
                    pUni = pUni.next;
                }
                p = p.next;
            }
            pDup.next=null;
            pUni.next=null;
            return dummyUni.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new P82RemoveDuplicatesFromSortedListIi().new Solution();
        // put your test code here
        
    }
}
