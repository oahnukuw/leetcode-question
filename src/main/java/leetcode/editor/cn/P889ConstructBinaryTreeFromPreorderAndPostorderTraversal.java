package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.cn.common.*;

public class P889ConstructBinaryTreeFromPreorderAndPostorderTraversal {

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

        HashMap<Integer, Integer> valToIndex;
        public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
            valToIndex = new HashMap<>();
            for (int i = 0; i < postorder.length; i++) {
                valToIndex.put(postorder[i], i);
            }
            return build(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);

        }

        private TreeNode build(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd) {
            if (preStart > preEnd ) {
                return null;
            }
            if (preStart == preEnd) {
                return new TreeNode(preorder[preStart]);
            }
            int leftVal = preorder[preStart + 1];
            int rootVal = preorder[preStart];
            Integer leftIndex = valToIndex.get(leftVal);
            int leftSize = leftIndex - postStart + 1;
            TreeNode root = new TreeNode(rootVal);
            root.left = build(preorder, preStart + 1, preStart + leftSize, postorder, postStart, postStart + leftSize - 1);
            root.right = build(preorder, preStart + leftSize + 1, preEnd, postorder, postStart + leftSize, postEnd - 1);

            return root;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        // put your test code here
        
    }
}
