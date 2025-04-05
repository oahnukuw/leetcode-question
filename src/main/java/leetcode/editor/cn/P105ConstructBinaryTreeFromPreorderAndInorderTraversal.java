package leetcode.editor.cn;

import leetcode.editor.cn.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class P105ConstructBinaryTreeFromPreorderAndInorderTraversal {

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
        Map<Integer, Integer> valToIndex = new HashMap<>();

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            for (int i = 0; i < inorder.length; i++) {
                valToIndex.put(inorder[i], i);
            }
            return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        }

        TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
            if (preEnd < preStart || inEnd < inStart) {
                return null;
            }
            int rootVal = preorder[preStart];
            Integer index = valToIndex.get(rootVal);
            int leftSize = index - inStart;
            TreeNode leftNode = build(preorder, preStart + 1, preStart + leftSize, inorder, inStart, index - 1);
            int rightSize = inEnd - index;
            TreeNode rightNode = build(preorder, preEnd - rightSize + 1, preEnd, inorder, index + 1, inEnd);
            TreeNode root = new TreeNode(rootVal);
            root.left = leftNode;
            root.right = rightNode;

            return root;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P105ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
        // put your test code here

    }
}
