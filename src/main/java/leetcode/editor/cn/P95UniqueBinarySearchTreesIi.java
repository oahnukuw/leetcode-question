package leetcode.editor.cn;

import leetcode.editor.cn.common.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class P95UniqueBinarySearchTreesIi {

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

        public List<TreeNode> generateTrees(int n) {
            if (n == 0) return new LinkedList<>();
            return build(1, n);
        }

        // Define: return BST root of [lo,hi]
        private List<TreeNode> build(int lo, int hi) {
            LinkedList<TreeNode> res = new LinkedList<>();
            if (lo > hi) {
                res.add(null);
                return res;
            }

            for (int i = lo; i <= hi; i++) {
                List<TreeNode> leftSubTrees = build(lo, i - 1);
                List<TreeNode> rightSubTrees = build(i + 1, hi);
                for (TreeNode left: leftSubTrees) {
                    for (TreeNode right: rightSubTrees) {
                        TreeNode root = new TreeNode(i);
                        root.left = left;
                        root.right = right;
                        res.add(root);
                    }
                }
            }
            return res;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P95UniqueBinarySearchTreesIi().new Solution();
        // put your test code here

    }
}
