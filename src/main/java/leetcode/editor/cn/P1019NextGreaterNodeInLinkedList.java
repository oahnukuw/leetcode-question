package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.cn.common.*;

public class P1019NextGreaterNodeInLinkedList {

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
        public int[] nextLargerNodes(ListNode head) {
            ListNode p = head;
            ArrayList<Integer> arrayList = new ArrayList<>();
            while (p != null) {
                arrayList.add(p.val);
                p = p.next;
            }
            Stack<Integer> s = new Stack<>();
            int[] res = new int[arrayList.size()];
            for (int i = arrayList.size()-1; i >= 0; i--) {
                while (!s.isEmpty() && s.peek() <= arrayList.get(i)) {
                    s.pop();
                }
                res[i] = s.isEmpty() ? 0 : s.peek();
                s.push(arrayList.get(i));
            }
            return res;
            
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new P1019NextGreaterNodeInLinkedList().new Solution();
        // put your test code here
        
    }
}
