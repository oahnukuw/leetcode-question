package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.cn.common.*;

public class P700SearchInABinarySearchTree {

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

        public TreeNode searchBST(TreeNode root, int val) {
            if (root == null) return null;
            if (root.val < val) {
                return searchBST(root.right, val);
            }
            if (root.val > val) {
                return searchBST(root.left, val);
            }

            return root;

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new P700SearchInABinarySearchTree().new Solution();
        // put your test code here
        
    }
}
