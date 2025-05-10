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
            // return heapMerge(lists);
            // Use divide and conquer
            if (lists.length==0) {
                return null;
            }
            return divideMerge(lists, 0, lists.length - 1);
        }

        private ListNode divideMerge(ListNode[] lists, int start, int end) {
            if (start==end) {
                return lists[start];
            }
            int mid = start + (end - start) / 2;
            ListNode left = divideMerge(lists, start, mid);
            ListNode right = divideMerge(lists, mid + 1, end);

            return mergeTwoLists(left, right);
        }

        ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode p = list1, q = list2;
            ListNode dummy = new ListNode(-1);
            ListNode m = dummy;
            while (p != null && q != null) {
                if (p.val > q.val) {
                    m.next = q;
                    q = q.next;
                } else {
                    m.next = p;
                    p = p.next;
                }
                m = m.next;
            }
            if (p != null) {
                m.next = p;
            }
            if (q != null) {
                m.next = q;
            }
            return dummy.next;
        }
        private ListNode heapMerge(ListNode[] lists) {
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
