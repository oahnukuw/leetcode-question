package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * $
 *
 * @author kunhao.wu@hand-china.com 8/29/2023$ 10:27 AM$
 */

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public static ListNode create(int[] list){
            ListNode dummy = new ListNode(-1);
            ListNode p = dummy;
            for (int array : list) {
                p.next = new ListNode(array);
                p = p.next;
            }
            return dummy.next;
        }

        public static void print(ListNode head){
            ListNode p = head;
            List<Integer> list = new ArrayList<>();
            while(p!=null){
                list.add(p.val);
                p = p.next;
            }
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
