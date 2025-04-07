package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.cn.common.*;

public class P1302DeepestLeavesSum {

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        public int deepestLeavesSum(TreeNode root) {
            ArrayList<Integer> leavesSum = new ArrayList<>();
            // levelOrder(root, leavesSum);
            traverse(root, leavesSum, 0);
            return leavesSum.get(leavesSum.size() - 1);
        }

        private void traverse(TreeNode root, ArrayList<Integer> leavesSum, int depth) {
            if (root == null) return;
            if (leavesSum.size() == depth) {
                leavesSum.add(root.val);
            } else {
                leavesSum.set(depth, leavesSum.get(depth) + root.val);
            }
            traverse(root.left, leavesSum, depth + 1);
            traverse(root.right, leavesSum, depth + 1);
        }

        private void levelOrder(TreeNode root, ArrayList<Integer> leavesSum) {
            if (root == null) return;
            Queue<TreeNode> q = new ArrayDeque<>();
            q.offer(root);
            while (!q.isEmpty()) {
                int size = q.size();
                int levelSum = 0;
                for (int i = 0; i < size; i++) {
                    TreeNode cur = q.poll();
                    levelSum += cur.val;
                    if (cur.left != null) {
                        q.offer(cur.left);
                    }
                    if (cur.right != null) {
                        q.offer(cur.right);
                    }
                }
                leavesSum.add(levelSum);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new P1302DeepestLeavesSum().new Solution();
        // put your test code here
        
    }
}
