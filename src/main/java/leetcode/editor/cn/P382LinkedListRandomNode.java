package leetcode.editor.cn;

import leetcode.editor.cn.common.ListNode;

import java.util.Random;

public class P382LinkedListRandomNode {

    // leetcode submit region begin(Prohibit modification and deletion)

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
        ListNode head;
        Random random = new Random();

        public Solution(ListNode head) {
            this.head = head;
        }

        public int getRandom() {
            int i = 0, res = 0;
            ListNode p = head;
            while (p != null) {
                i++;
                int j = random.nextInt(i);
                if (j == 0) {
                    res = p.val;
                }
                p = p.next;
            }
            return res;
        }
    }

    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(head);
     * int param_1 = obj.getRandom();
     */
    // leetcode submit region end(Prohibit modification and deletion)
    public static void main(String[] args) {
        // put your test code here

    }
}
