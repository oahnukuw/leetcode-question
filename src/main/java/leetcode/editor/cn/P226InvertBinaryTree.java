package leetcode.editor.cn;

import leetcode.editor.cn.common.TreeNode;

import java.util.concurrent.TransferQueue;
import java.util.logging.Level;

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
            // if (root == null) {
            //     return null;
            // }
            // TreeNode left = invertTree(root.left);
            // TreeNode right = invertTree(root.right);
            // root.left = right;
            // root.right = left;
            // return root;

            invertByTraverse(root);
            return root;
        }

        private void invertByTraverse(TreeNode root) {
            if (root == null) return;
            TreeNode left = root.left;
            TreeNode right = root.right;
            root.left = right;
            root.right = left;
            invertByTraverse(root.left);
            invertByTraverse(root.right);
        }


    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P226InvertBinaryTree().new Solution();
        // put your test code here

    }
}
