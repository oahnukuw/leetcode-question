package leetcode.editor.cn;

import leetcode.editor.cn.common.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P23MergeKSortedLists {

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
        public ListNode mergeKLists(ListNode[] lists) {
            ListNode dummy = new ListNode(-1);
            ListNode p = dummy;
            PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));

            for (ListNode head : lists) {
                if (head != null) {
                    pq.offer(head);
                }
            }
            while (!pq.isEmpty()) {
                ListNode temp = pq.poll();
                p.next = temp;
                p = p.next;
                if (temp.next != null) {
                    pq.offer(temp.next);
                }
                temp.next = null;
            }
            return dummy.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P23MergeKSortedLists().new Solution();
        // put your test code here

    }
}
