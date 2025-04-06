package leetcode.editor.cn;

import leetcode.editor.cn.common.TreeNode;

public class P129SumRootToLeafNumbers {

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
     * this.right = rightvoid;
     * }
     * }
     */
    class Solution {
        StringBuilder pathNum = new StringBuilder();
        int res = 0;

        public int sumNumbers(TreeNode root) {
            traverse(root);
            return res;
        }

        private void traverse(TreeNode root) {
            if (root == null) return;
            pathNum.append(root.val);
            if (root.left == null && root.right == null) {
                res += Integer.parseInt(pathNum.toString());
            }
            traverse(root.left);
            traverse(root.right);
            pathNum.deleteCharAt(pathNum.length() - 1);
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P129SumRootToLeafNumbers().new Solution();
        // put your test code here

    }
}
