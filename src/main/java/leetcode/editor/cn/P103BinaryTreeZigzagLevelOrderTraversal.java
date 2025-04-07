package leetcode.editor.cn;

import leetcode.editor.cn.common.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P103BinaryTreeZigzagLevelOrderTraversal {

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
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            if (root == null) return new LinkedList<>();
            LinkedList<List<Integer>> res = new LinkedList<>();
            Queue<TreeNode> q = new ArrayDeque<>();
            q.offer(root);
            boolean reverse = false;
            while (!q.isEmpty()) {
                int size = q.size();
                LinkedList<Integer> level = new LinkedList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode cur = q.poll();
                    if (reverse) {
                        level.addFirst(cur.val);
                    } else {
                        level.add(cur.val);
                    }
                    if (cur.left != null) {
                        q.offer(cur.left);
                    }
                    if (cur.right != null) {
                        q.offer(cur.right);
                    }
                }
                res.add(level);
                reverse = !reverse;
            }
            return res;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P103BinaryTreeZigzagLevelOrderTraversal().new Solution();
        // put your test code here

    }
}
