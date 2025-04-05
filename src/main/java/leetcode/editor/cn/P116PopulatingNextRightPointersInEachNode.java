package leetcode.editor.cn;

import leetcode.editor.ds.Node;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

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
            // if (root == null) {
            //     return null;
            // }
            // traverse(root.left, root.right);
            // return root;

            if (root == null) {
                return null;
            }
            Deque<Node> deque = new LinkedList<>();
            deque.offer(root);
            while (!deque.isEmpty()) {
                int size = deque.size();
                for (int i = 0; i < size; i++) {
                    Node node = deque.pop();
                    if (i < size - 1) {
                        node.next = deque.peek();
                    }
                    if (node.left != null) {
                        deque.offer(node.left);
                    }
                    if (node.right != null) {
                        deque.offer(node.right);
                    }
                }
            }
            return root;
        }

        void traverse(Node node1, Node node2) {
            if (node1 == null || node2 == null) {
                return;
            }

            node1.next = node2;
            traverse(node1.left,node1.right);
            traverse(node2.left,node2.right);
            traverse(node1.right, node2.left);

        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P116PopulatingNextRightPointersInEachNode().new Solution();
        // put your test code here

    }
}
