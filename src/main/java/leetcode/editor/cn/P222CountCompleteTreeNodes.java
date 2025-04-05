package leetcode.editor.cn;

import leetcode.editor.cn.common.TreeNode;

public class P222CountCompleteTreeNodes {

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
        public int countNodes(TreeNode root) {
            if (root == null) return 0;
            TreeNode l = root.left, r = root.right;
            int lh = 1, rh = 1;
            while (l != null) {
                lh++;
                l = l.left;
            }
            while (r != null) {
                rh++;
                r = r.right;
            }
            if (rh == lh) {
                return (int) Math.pow(2, rh) - 1;
            }
            return 1 + countNodes(root.left) + countNodes(root.right);

        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P222CountCompleteTreeNodes().new Solution();
        // put your test code here

    }
}
