package leetcode.editor.cn;

import leetcode.editor.cn.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class P1609EvenOddTree {

    // leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public boolean isEvenOddTree(TreeNode root) {
            boolean isOdd = true;
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()) {
                int size = q.size();
                int prev = isOdd ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                for (int i = 0; i < size; i++) {
                    TreeNode cur = q.poll();
                    if (isOdd) {
                        if (cur.val % 2 == 0 || prev >= cur.val) {
                            return false;
                        }
                    }
                    if (!isOdd) {
                        if (cur.val % 2 != 0 || prev <= cur.val) {
                            return false;
                        }
                    }
                    prev = cur.val;
                    if (cur.left != null) {
                        q.offer(cur.left);
                    }
                    if (cur.right != null) {
                        q.offer(cur.right);
                    }
                }
                isOdd = !isOdd;
            }
            return true;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P1609EvenOddTree().new Solution();
        // put your test code here

    }
}
