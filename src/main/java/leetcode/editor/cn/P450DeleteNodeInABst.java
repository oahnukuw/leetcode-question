package leetcode.editor.cn;

import leetcode.editor.cn.common.TreeNode;

public class P450DeleteNodeInABst {

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
        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null) return null;
            if (root.val == key) {
                // delete node
                // 1. no children
                // 2. has only one child
                if (root.left == null) return root.right;
                if (root.right == null) return root.left;
                // 3. has two children: get the min of right child as rightMin, and then delete it, rightMin will be the new node to return
                TreeNode rightMin = getMin(root.right);
                root.right = deleteNode(root.right, rightMin.val);
                rightMin.left = root.left;
                rightMin.right = root.right;
                root = rightMin;

            } else if (root.val < key) {
                root.right = deleteNode(root.right, key);
            } else if (root.val > key) {
                root.left = deleteNode(root.left, key);
            }
            return root;
        }

        private TreeNode getMin(TreeNode root) {
            TreeNode p = root;
            while (p.left != null) {
                p = p.left;
            }
            return p;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P450DeleteNodeInABst().new Solution();
        // put your test code here

    }
}
