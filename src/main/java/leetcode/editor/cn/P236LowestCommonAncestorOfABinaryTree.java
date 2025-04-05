package leetcode.editor.cn;

import leetcode.editor.cn.common.TreeNode;

public class P236LowestCommonAncestorOfABinaryTree {

    // leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        // TreeNode lca = null;
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            return find(root, p, q);

        }

        private TreeNode find(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) return null;
            // if (lca != null) {
            //     return null;
            // }
            if (root.equals(p) || root.equals(q)) {
                return root;
            }
            TreeNode left = find(root.left, p, q);
            TreeNode right = find(root.right, p, q);
            if (left != null && right != null) {
                // lca = root;
                return root;
            }
            return left == null ? right : left;

        }

    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        // put your test code here

    }
}
