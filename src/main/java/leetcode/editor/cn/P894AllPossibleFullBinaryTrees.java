package leetcode.editor.cn;

import leetcode.editor.cn.common.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class P894AllPossibleFullBinaryTrees {

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
        List<TreeNode>[] memo;

        public List<TreeNode> allPossibleFBT(int n) {
            if (n % 2 == 0) return new LinkedList<>();
            memo = new LinkedList[n + 1];
            return build(n);
        }

        private List<TreeNode> build(int n) {
            LinkedList<TreeNode> nodeList = new LinkedList<>();
            if (n == 1) {
                nodeList.add(new TreeNode(0));
                return nodeList;
            }
            if (memo[n] != null) {
                return memo[n];
            }

            for (int i = 1; i < n; i += 2) {
                int j = n - 1 - i;
                List<TreeNode> leftTreeNodes = build(i);
                List<TreeNode> righTreeNodes = build(j);
                for (TreeNode leftTreeNode : leftTreeNodes) {
                    for (TreeNode righTreeNode : righTreeNodes) {
                        TreeNode root = new TreeNode(0);
                        root.left = leftTreeNode;
                        root.right = righTreeNode;
                        nodeList.add(root);
                    }
                }
            }
            memo[n] = nodeList;
            return nodeList;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P894AllPossibleFullBinaryTrees().new Solution();
        // put your test code here

    }
}
