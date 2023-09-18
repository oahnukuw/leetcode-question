//输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。 
//
// 示例1： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4 
//
// 限制： 
//
// 0 <= 链表长度 <= 1000 
//
// 注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/ 
//
// Related Topics递归 | 链表 
//
// 👍 379, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

//Java：合并两个排序的链表
public class HeBingLiangGePaiXuDeLianBiaoLcof{
    public static void main(String[] args) {
        Solution solution = new HeBingLiangGePaiXuDeLianBiaoLcof().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode p1=l1, p2=l2, p=dummy;
        while(p1!=null && p2!=null){
            if(p1.val<p2.val){
                p.next=p1;
                p1=p1.next;
            }else {
                p.next=p2;
                p2=p2.next;
            }
            p=p.next;
        }
        while(p1!=null){
            p.next=p1;
            p1=p1.next;
            p=p.next;
        }
        while(p2!=null){
            p.next=p2;
            p2=p2.next;
            p=p.next;
        }
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
