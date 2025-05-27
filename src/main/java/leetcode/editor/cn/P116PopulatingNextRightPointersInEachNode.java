package leetcode.editor.cn;

import leetcode.editor.ds.Node;

public class P116PopulatingNextRightPointersInEachNode {

    // leetcode submit region begin(Prohibit modification and deletion)
    /*
    // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
    
        public Node() {}
        
        public Node(int _val) {
            val = _val;
        }
    
        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
    */;

    class Solution {
        public Node connect(Node root) {
            if (root == null) return null;
            traverse(root.left, root.right);
            return root;
        }

        private void traverse(Node left, Node right) {
            if (left == null || right == null) return;
            left.next = right;
            traverse(left.left, left.right);
            traverse(left.right, right.left);
            traverse(right.left, right.right);

        }

    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P116PopulatingNextRightPointersInEachNode().new Solution();
        // put your test code here

    }
}
