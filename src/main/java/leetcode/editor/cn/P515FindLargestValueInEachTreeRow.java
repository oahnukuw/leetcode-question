package leetcode.editor.cn;

import leetcode.editor.cn.common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P515FindLargestValueInEachTreeRow {

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
        public List<Integer> largestValues(TreeNode root) {
            LinkedList<Integer> res;
            res = new LinkedList<>();
            // levelOrder(root, res);
            traverse(root, res, 0);
            return res;
        }

        private void traverse(TreeNode root, LinkedList<Integer> res, int depth) {
            if (root == null) return;
            if (res.size() == depth) {
                res.add(root.val);
            } else {
                res.set(depth, Math.max(res.get(depth), root.val));
            }
            traverse(root.left, res, depth + 1);
            traverse(root.right, res, depth + 1);
        }

        private void levelOrder(TreeNode root, LinkedList<Integer> res) {
            if (root == null) return;
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()) {
                int size = q.size();
                int levelMax = Integer.MIN_VALUE;
                for (int i = 0; i < size; i++) {
                    TreeNode cur = q.poll();
                    levelMax = Math.max(cur.val, levelMax);
                    if (cur.left != null) {
                        q.offer(cur.left);
                    }
                    if (cur.right != null) {
                        q.offer(cur.right);
                    }
                }
                res.add(levelMax);
            }
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P515FindLargestValueInEachTreeRow().new Solution();
        // put your test code here

    }
}
