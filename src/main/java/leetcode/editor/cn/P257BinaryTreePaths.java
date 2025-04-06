package leetcode.editor.cn;

import leetcode.editor.cn.common.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class P257BinaryTreePaths {

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
        LinkedList<String> res = new LinkedList<>();
        LinkedList<String> path = new LinkedList<>();

        public List<String> binaryTreePaths(TreeNode root) {
            findPath(root);
            return res;
        }

        private void findPath(TreeNode root) {
            if (root == null) {
                return;
            }
            path.addLast(String.valueOf(root.val));
            if (root.left == null && root.right == null) {
                res.addLast(String.join("->", path));
            }
            findPath(root.left);
            findPath(root.right);
            path.removeLast();
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P257BinaryTreePaths().new Solution();
        // put your test code here

    }
}
