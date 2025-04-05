package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.cn.common.*;

public class P106ConstructBinaryTreeFromInorderAndPostorderTraversal {

    //leetcode submit region begin(Prohibit modification and deletion)

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

        Map<Integer, Integer> valToIndex = new HashMap<>();

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            for (int i = 0; i < inorder.length; i++) {
                valToIndex.put(inorder[i], i);
            }
            return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);

        }

        private TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {

            if (inEnd < inStart) {
                return null;
            }
            int rootVal = postorder[postEnd];
            Integer rootIndex = valToIndex.get(rootVal);
            int rightSize = inEnd - rootIndex;
            TreeNode root = new TreeNode(rootVal);
            root.left = build(inorder, inStart, rootIndex - 1, postorder, postStart, postEnd - rightSize - 1);
            root.right = build(inorder, rootIndex + 1, inEnd, postorder, postEnd - rightSize, postEnd - 1);

            return root;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new P106ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
        // put your test code here
        
    }
}
