package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.cn.common.*;

public class P701InsertIntoABinarySearchTree {

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
        public TreeNode insertIntoBST(TreeNode root, int val) {
            if (root == null) return new TreeNode(val);
            if (root.val > val) {
                root.left = insertIntoBST(root.left, val);
            }
            if (root.val < val) {
                root.right = insertIntoBST(root.right, val);
            }
            return root;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new P701InsertIntoABinarySearchTree().new Solution();
        // put your test code here
        
    }
}
