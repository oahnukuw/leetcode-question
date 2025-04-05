package leetcode.editor.cn;

import leetcode.editor.cn.common.TreeNode;

public class P226InvertBinaryTree {

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
        public TreeNode invertTree(TreeNode root) {
            // return reverse(root);
            iteratingReverse(root);
            return root;
        }

        TreeNode reverse(TreeNode root) {
            if (root == null) {
                return null;
            }
            TreeNode left = reverse(root.left);
            TreeNode right = reverse(root.right);
            root.left = right;
            root.right = left;
            return root;
        }

        void iteratingReverse(TreeNode root) {
            if (root == null) {
                return;
            }
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            iteratingReverse(root.left);
            iteratingReverse(root.right);

        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P226InvertBinaryTree().new Solution();
        // put your test code here

    }
}
