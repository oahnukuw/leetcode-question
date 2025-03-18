package leetcode.editor.cn;

import leetcode.editor.cn.common.ListNode;

public class P61RotateList {

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
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null) {
                return null;
            }
            ListNode p = head;
            int n = 0;
            while (p != null) {
                n++;
                p=p.next;
            }
            ListNode kHead = head;
            // move forward n-k-1 step
            int realK = k % n;
            for (int i = 0; i < n - realK - 1; i++) {
                kHead = kHead.next;
            }
            kHead.next = reverseN(kHead.next, realK);
            ListNode reversedHead = reverseN(head, n - realK);
            return reverseN(reversedHead, n);
        }

        private ListNode reverseN(ListNode head, int n) {
            if (n == 0) {
                return head;
            }
            ListNode p = head, pre = null;
            while (n > 0 && p != null) {
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
        Solution solution = new P61RotateList().new Solution();
        // put your test code here
        ListNode node = new ListNode(1);
        solution.rotateRight(null, 0);
        
    }
}
