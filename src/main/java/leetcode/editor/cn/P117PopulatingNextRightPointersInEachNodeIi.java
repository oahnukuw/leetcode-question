package leetcode.editor.cn;

import leetcode.editor.ds.Node;

import java.util.ArrayDeque;
import java.util.Queue;

public class P117PopulatingNextRightPointersInEachNodeIi {

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
    */

    class Solution {
        public Node connect(Node root) {
            if (root == null) return null;
            Queue<Node> q = new ArrayDeque<>();
            q.offer(root);
            while (!q.isEmpty()) {
                int size = q.size();
                Node pre = null;
                for (int i = 0; i < size; i++) {
                    Node cur = q.poll();
                    if (pre != null) {
                        pre.next = cur;
                    }
                    pre = cur;
                    if (cur.left != null) {
                        q.offer(cur.left);
                    }
                    if (cur.right != null) {
                        q.offer(cur.right);
                    }
                }
            }
            return root;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P117PopulatingNextRightPointersInEachNodeIi().new Solution();
        // put your test code here

    }
}
