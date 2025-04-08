package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.cn.common.*;

public class P1038BinarySearchTreeToGreaterSumTree {

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
        int sum;
        public TreeNode bstToGst(TreeNode root) {
            sum = 0;
            traverse(root);
            return root;
        }

        private void traverse(TreeNode root) {
            if (root == null) return;
            traverse(root.right);
            sum += root.val;
            root.val = sum;
            traverse(root.left);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new P1038BinarySearchTreeToGreaterSumTree().new Solution();
        // put your test code here
        
    }
}
