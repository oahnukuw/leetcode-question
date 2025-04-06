package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.cn.common.*;

public class P199BinaryTreeRightSideView {

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
        LinkedList<Integer> res;
        int depth = 0;
        public List<Integer> rightSideView(TreeNode root) {
            res = new LinkedList<>();
            // levelTraverse(root);
            deepTraverse(root);
            return res;
        }

        private void deepTraverse(TreeNode root) {
            if (root == null) return;
            depth++;
            if (res.size() < depth) {
                res.add(root.val);
            }
            deepTraverse(root.right);
            deepTraverse(root.left);
            depth--;
        }

        private void levelTraverse(TreeNode root) {
            if (root == null) return;
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()) {
                int size = q.size();
                TreeNode last = q.peek();
                for (int i = 0; i < size; i++) {
                    TreeNode current = q.poll();
                    if (current.right != null) q.offer(current.right);
                    if (current.left != null) q.offer(current.left);
                }
                res.add(last.val);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new P199BinaryTreeRightSideView().new Solution();
        // put your test code here
        
    }
}
