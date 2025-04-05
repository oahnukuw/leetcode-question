package leetcode.editor.cn;


import leetcode.editor.cn.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class P297SerializeAndDeserializeBinaryTree {

    // leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public class Codec {

        // Encodes a tree to a single string.
        private static final String SEP = ",";
        private static final String NULL = "#";
        StringBuilder sb = new StringBuilder();

        public String serialize(TreeNode root) {
            // preSerialize(root);
            // postSerialize(root);
            levelSerialize(root);
            return sb.toString();
        }

        private void levelSerialize(TreeNode root) {
            if (root == null) {
                return;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (node == null) {
                        sb.append(NULL).append(SEP);
                        continue;
                    }
                    sb.append(node.val).append(SEP);
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
        }

        private void postSerialize(TreeNode root) {
            if (root == null) {
                sb.append(NULL).append(SEP);
                return;
            }
            postSerialize(root.left);
            postSerialize(root.right);
            sb.append(root.val).append(SEP);
        }

        private void preSerialize(TreeNode root) {
            if (root == null) {
                sb.append(NULL).append(SEP);
                return;
            }
            sb.append(root.val).append(SEP);
            preSerialize(root.left);
            preSerialize(root.right);
        }


        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.isEmpty()) {
                return null;
            }
            String[] split = data.split(SEP);
            // LinkedList<String> nodes = new LinkedList<>(Arrays.asList(split));
            // return preDeserialize(nodes);
            // return postDeserialize(nodes);
            return levelDeserialize(split);
        }

        private TreeNode levelDeserialize(String[] nodes) {
            if (nodes.length == 0) {
                return null;
            }
            TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            int index = 1;
            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    TreeNode parent = q.poll();
                    String left = nodes[index++];
                    if (!left.equals(NULL)) {
                        TreeNode leftNode = new TreeNode(Integer.parseInt(left));
                        parent.left = leftNode;
                        q.offer(leftNode);
                    }
                    String right = nodes[index++];
                    if (!right.equals(NULL)) {
                        TreeNode rightNode = new TreeNode(Integer.parseInt(right));
                        q.offer(rightNode);
                        parent.right = rightNode;
                    }

                }
            }
            return root;
        }

        private TreeNode postDeserialize(LinkedList<String> nodes) {
            if (nodes.isEmpty()) {
                return null;
            }
            String s = nodes.removeLast();
            if (s.equals(NULL)) {
                return null;
            }
            TreeNode rightNode = postDeserialize(nodes);
            TreeNode leftNode = postDeserialize(nodes);
            TreeNode root;
            root = new TreeNode(Integer.parseInt(s));
            root.left = leftNode;
            root.right = rightNode;
            return root;
        }

        private TreeNode preDeserialize(LinkedList<String> nodes) {
            if (nodes.isEmpty()) return null;
            String first = nodes.removeFirst();
            if (first.equals(NULL)) {
                return null;
            }
            TreeNode root = new TreeNode(Integer.parseInt(first));
            root.left = preDeserialize(nodes);
            root.right = preDeserialize(nodes);
            return root;
        }


    }

    // Your Codec object will be instantiated and called as such:
    // Codec ser = new Codec();
    // Codec deser = new Codec();
    // TreeNode ans = deser.deserialize(ser.serialize(root));
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        // put your test code here

    }
}
