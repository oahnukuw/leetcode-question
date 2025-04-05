package leetcode.editor.cn;

import leetcode.editor.cn.common.*;

public class P654MaximumBinaryTree {

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
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            //Find the biggest element and the index
            //Find the biggest element between [0,index-1]
            //Find the biggest element between [index+1,nums.length-1]
            return build(nums, 0, nums.length - 1);
        }

        TreeNode build(int[] nums, int low, int high) {
            if (low > high) {
                return null;
            }
            int max = -1;
            int index = -1;
            for (int i = low; i <= high; i++) {
                if (max < nums[i]) {
                    max = nums[i];
                    index = i;
                }
            }
            TreeNode left = build(nums, low, index - 1);
            TreeNode right = build(nums, index + 1, high);
            TreeNode root = new TreeNode(max);
            root.left = left;
            root.right = right;
            return root;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new P654MaximumBinaryTree().new Solution();
        // put your test code here
        
    }
}
