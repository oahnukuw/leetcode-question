package leetcode.editor.cn;

import leetcode.editor.cn.common.ListNode;

import java.util.List;
import java.util.Stack;

public class P143ReorderList {

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
        private final Stack<ListNode> stack = new Stack<>();

        public void reorderList(ListNode head) {
            ListNode p = head;
            while (p != null) {
                stack.push(p);
                p = p.next;
            }
            p = head;
            while (p != null) {
                ListNode lastNode = stack.pop();
                if (lastNode == p.next || lastNode.next == p.next) {
                    lastNode.next = null;
                    break;
                }
                lastNode.next = p.next;
                p.next = lastNode;
                p = lastNode.next;
            }

        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P143ReorderList().new Solution();
        // put your test code here

    }
}
