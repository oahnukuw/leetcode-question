package leetcode.editor.cn;

import leetcode.editor.cn.common.TreeNode;

public class P1457PseudoPalindromicPathsInABinaryTree {

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
        int res;
        int[] count;

        public int pseudoPalindromicPaths(TreeNode root) {
            res = 0;
            count = new int[10];
            traverse(root);
            return res;
        }

        private void traverse(TreeNode root) {
            if (root == null) return;
            count[root.val]++;
            if (root.left == null && root.right == null) {
                int odd = 0;
                for (int n : count) {
                    if (n % 2 == 1) odd++;
                }
                if (odd <= 1) res++;
            }
            traverse(root.left);
            traverse(root.right);
            count[root.val]--;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P1457PseudoPalindromicPathsInABinaryTree().new Solution();
        // put your test code here

    }
}
