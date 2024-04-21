package leetcode.editor.cn.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

    public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
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
