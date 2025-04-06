package leetcode.editor.cn;

import leetcode.editor.cn.common.TreeNode;

import java.util.LinkedList;

public class P1022SumOfRootToLeafBinaryNumbers {

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
        int sum;
        int path;

        public int sumRootToLeaf(TreeNode root) {
            sum = 0;
            path = 0;
            traverse(root);
            return sum;
        }

        private void traverse(TreeNode root) {
            if (root == null) return;
            path = path << 1 | root.val;
            if (root.left == null && root.right == null) {
                sum += path;
            }
            traverse(root.left);
            traverse(root.right);
            path = path >> 1;

        }


    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P1022SumOfRootToLeafBinaryNumbers().new Solution();
        // put your test code here

    }
}
