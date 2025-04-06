package leetcode.editor.cn;

import leetcode.editor.cn.common.TreeNode;

public class P988SmallestStringStartingFromLeaf {

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
        StringBuilder path;
        String res = null;

        public String smallestFromLeaf(TreeNode root) {
            path = new StringBuilder();
            traverse(root);
            return res;
        }

        private void traverse(TreeNode root) {
            if (root == null) return;

            path.append((char) (root.val + 'a'));
            if (root.left == null && root.right == null) {
                String s = path.reverse().toString();
                if (res == null || res.compareTo(s) > 0) {
                    res = s;
                }
                path.reverse();
            }
            traverse(root.left);
            traverse(root.right);
            path.deleteCharAt(path.length() - 1);

        }

    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P988SmallestStringStartingFromLeaf().new Solution();
        // put your test code here

    }
}
