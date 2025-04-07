package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.cn.common.*;

public class P1110DeleteNodesAndReturnForest {

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
        List<TreeNode> res;
        Set<Integer> toDeleteSet;
        public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
            res = new ArrayList<>();
            toDeleteSet = new HashSet<>();
            if (root == null) return res;
            for (int i : to_delete) {
                toDeleteSet.add(i);
            }
            doDelete(root, false);
            return res;

        }

        private TreeNode doDelete(TreeNode root, boolean hasParent) {
            if (root == null) return null;
            boolean deleted = toDeleteSet.contains(root.val);
            if (!deleted && !hasParent) {
                res.add(root);
            }
            root.left = doDelete(root.left, !deleted);
            root.right = doDelete(root.right, !deleted);

            return deleted ? null : root;

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new P1110DeleteNodesAndReturnForest().new Solution();
        // put your test code here
        
    }
}
