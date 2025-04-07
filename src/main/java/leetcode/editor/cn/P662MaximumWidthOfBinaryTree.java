package leetcode.editor.cn;

import leetcode.editor.cn.common.TreeNode;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class P662MaximumWidthOfBinaryTree {

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
        class Pair {
            int id;
            TreeNode node;

            public Pair(int id, TreeNode node) {
                this.id = id;
                this.node = node;
            }
        }

        public int widthOfBinaryTree(TreeNode root) {
            int res = 0;
            Queue<Pair> q = new LinkedList<>();
            q.offer(new Pair(1, root));
            while (!q.isEmpty()) {
                int size = q.size();
                int start = 0, end = 0;
                for (int i = 0; i < size; i++) {
                    Pair cur = q.poll();
                    int curId = cur.id;
                    TreeNode curNode = cur.node;
                    if (i == 0) {
                        start = curId;
                    }
                    if (i == size - 1) {
                        end = curId;
                    }
                    if (curNode.left != null) {
                        q.offer(new Pair(2 * curId, curNode.left));
                    }
                    if (curNode.right != null) {
                        q.offer(new Pair(2 * curId + 1, curNode.right));
                    }
                }
                res = Math.max(res, end - start + 1);
            }
            return res;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P662MaximumWidthOfBinaryTree().new Solution();
        // put your test code here

    }
}
