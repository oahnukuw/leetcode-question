package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.cn.common.*;

public class P1161MaximumLevelSumOfABinaryTree {

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
        public int maxLevelSum(TreeNode root) {
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            int max = Integer.MIN_VALUE;
            int depth = 1;
            int res = 0;
            while (!q.isEmpty()) {
                int size = q.size();
                int sum = 0;
                for (int i = 0; i < size; i++) {
                    TreeNode cur = q.poll();
                    sum += cur.val;
                    if (cur.left != null) {
                        q.offer(cur.left);
                    }
                    if (cur.right != null) {
                        q.offer(cur.right);
                    }
                }
                if (sum > max) {
                    max = sum;
                    res = depth;
                }
                depth++;

            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new P1161MaximumLevelSumOfABinaryTree().new Solution();
        // put your test code here
        
    }
}
