package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.cn.common.*;

public class P144BinaryTreePreorderTraversal {

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
        List<Integer> list = new ArrayList<>();
        public List<Integer> preorderTraversal(TreeNode root) {
            traverse(root);
            return list;
        }

        void traverse(TreeNode root) {
            if (root == null) {
                return;
            }
            list.add(root.val);
            traverse(root.left);
            traverse(root.right);

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new P144BinaryTreePreorderTraversal().new Solution();
        // put your test code here
        
    }
}
