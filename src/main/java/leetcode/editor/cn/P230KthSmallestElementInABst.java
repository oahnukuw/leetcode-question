package leetcode.editor.cn;

import leetcode.editor.cn.common.TreeNode;

public class P230KthSmallestElementInABst {

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
        int n = 0;
        int res = 0;

        public int kthSmallest(TreeNode root, int k) {
            n = k;
            traverse(root);
            return res;
        }

        private void traverse(TreeNode root) {
            if (root == null || n == 0) {
                return;
            }
            traverse(root.left);
            n--;
            if (n == 0) {
                res = root.val;
            }
            traverse(root.right);
        }


    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P230KthSmallestElementInABst().new Solution();
        // put your test code here

    }
}
