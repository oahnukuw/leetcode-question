package leetcode.editor.cn;

import java.util.HashMap;

public class P146LruCache {

    // leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {
        private HashMap<Integer, Node> map;
        private DoubleList cache;
        private int cap;

        public LRUCache(int capacity) {
            this.cap = capacity;
            map = new HashMap<>();
            cache = new DoubleList();
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            makeRecently(key);
            return map.get(key).val;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                makeRecently(key);
                map.get(key).val = value;
                return;
            }
            if (map.size() == cap) {
                removeLastRecently();
            }
            addRecently(key, value);
        }

        private void makeRecently(int key) {
            Node x = map.get(key);
            cache.remove(x);
            cache.addLast(x);
        }

        private void addRecently(int key, int value) {
            Node node = new Node(key, value);
            cache.addLast(node);
            map.put(key, node);
        }

        private void deleteKey(int key) {
            Node x = map.get(key);
            cache.remove(x);
            map.remove(key);
        }

        private void removeLastRecently() {
            Node x = cache.removeFirst();
            map.remove(x.key);
        }
    }

    class Node {
        int key, val;
        Node prev, next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    class DoubleList {

        private final Node head;
        private final Node tail;
        private int size;

        public DoubleList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        public void addLast(Node node) {
            node.prev = tail.prev;
            node.next = tail;
            tail.prev.next = node;
            tail.prev = node;
            size++;
        }

        // Guarantee node exists in the list
        public void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        public Node removeFirst() {
            if (head.next == tail) {
                return null;
            }
            Node first = head.next;
            remove(first);
            return first;
        }

        public int size() {
            return size;
        }
    }


    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
    // leetcode submit region end(Prohibit modification and deletion)
    public static void main(String[] args) {
        // put your test code here

    }
}
