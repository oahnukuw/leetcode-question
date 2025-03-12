package leetcode.editor.cn;

import leetcode.editor.cn.common.ListNode;

public class P25ReverseNodesInKGroup {

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
        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null) return null;
            ListNode a, b;
            a = b = head;
            for (int i = 0; i < k; i++) {
                if (b == null) return head;
                b = b.next;
            }
            ListNode res = reverseN(a, k);
            head.next = reverseKGroup(b, k);
            return res;
        }

        private ListNode reverseN(ListNode head, int n) {
            ListNode pre = null, p = head;
            while (n > 0) {
                ListNode cur = p;
                p = p.next;
                cur.next = pre;
                pre = cur;
                n--;
            }
            head.next = p;
            return pre;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new P25ReverseNodesInKGroup().new Solution();
        // put your test code here
        
    }
}
