package leetcode.editor.cn;

import leetcode.editor.cn.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class P919CompleteBinaryTreeInserter {

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
    class CBTInserter {
        TreeNode root;
        Queue<TreeNode> ableQueue;

        public CBTInserter(TreeNode root) {
            this.root = root;
            ableQueue = new ArrayDeque<>();
            Queue<TreeNode> tempQueue = new ArrayDeque<>();
            tempQueue.offer(root);
            while (!tempQueue.isEmpty()) {
                TreeNode cur = tempQueue.poll();
                if (cur.left != null) {
                    tempQueue.offer(cur.left);
                }
                if (cur.right != null) {
                    tempQueue.offer(cur.right);
                }
                if (cur.left == null || cur.right == null) {
                    ableQueue.offer(cur);
                }
            }
        }

        public int insert(int val) {
            TreeNode node = new TreeNode(val);
            TreeNode cur = ableQueue.peek();
            if (cur.left == null) {
                cur.left = node;
            } else if (cur.right == null) {
                cur.right = node;
                ableQueue.poll();
            }
            ableQueue.offer(node);
            return cur.val;
        }

        public TreeNode get_root() {
            return this.root;
        }
    }

    /**
     * Your CBTInserter object will be instantiated and called as such:
     * CBTInserter obj = new CBTInserter(root);
     * int param_1 = obj.insert(val);
     * TreeNode param_2 = obj.get_root();
     */
    // leetcode submit region end(Prohibit modification and deletion)
    public static void main(String[] args) {
        // put your test code here

    }
}
