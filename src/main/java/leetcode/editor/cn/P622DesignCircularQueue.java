package leetcode.editor.cn;

public class P622DesignCircularQueue {

    // leetcode submit region begin(Prohibit modification and deletion)
    class MyCircularQueue {

        ArrayQueue<Integer> queue;
        int maxCap;

        public MyCircularQueue(int k) {
            queue = new ArrayQueue<>();
            maxCap = k;
        }

        public boolean enQueue(int value) {
            if (queue.size() == maxCap) {
                return false;
            }
            queue.enQueue(value);
            return true;
        }

        public boolean deQueue() {
            return queue.deQueue() != null;
        }

        public int Front() {
            return queue.Front() == null ? -1 : queue.Front();
        }

        public int Rear() {
            return queue.Rear() == null ? -1 : queue.Rear();
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }

        public boolean isFull() {
            return queue.size() == maxCap;
        }
    }

    class ArrayQueue<E> {
        private final static int INIT_CAP = 16;
        private Object[] elements;
        private int size;

        private int head, tail;
        private int capacity;

        public ArrayQueue() {
            this(INIT_CAP);
        }

        public ArrayQueue(int initCap) {
            elements = new Object[initCap];
            size = 0;
            head = tail = 0;
            capacity = initCap;
        }

        public void enQueue(E value) {
            if (size == capacity) {
                resize(2 * size);
            }

            elements[tail++] = value;
            size++;

            if (tail == capacity) {
                tail = 0;
            }
        }

        public E deQueue() {

            if (size < capacity / 4) {
                resize(capacity / 2);
            }

            @SuppressWarnings("unchecked")
            E result = (E) elements[head];
            if (result == null) {
                return null;
            }
            size--;
            elements[head] = null;

            head = (head + 1) & (capacity - 1);
            return result;
        }

        private void resize(int newCap) {
            Object[] a = new Object[newCap];
            for (int i = 0; i < size; i++) {
                a[i] = elements[(head + i) & capacity - 1];
            }
            this.elements = a;
            head = 0;
            tail = this.size;
            this.capacity = newCap;
        }

        @SuppressWarnings("unchecked")
        public E Front() {
            if (this.isEmpty()) {
                return null;
            }
            return (E) elements[head];
        }

        @SuppressWarnings("unchecked")
        public E Rear() {
            if (this.isEmpty()) {
                return null;
            }
            if (tail == 0) {
                return (E) elements[capacity - 1];
            }
            return (E) elements[tail - 1];
        }

        public boolean isEmpty() {
            return this.size == 0;
        }

        public int size() {
            return size;
        }
    }


    /**
     * Your MyCircularQueue object will be instantiated and called as such:
     * MyCircularQueue obj = new MyCircularQueue(k);
     * boolean param_1 = obj.enQueue(value);
     * boolean param_2 = obj.deQueue();
     * int param_3 = obj.Front();
     * int param_4 = obj.Rear();
     * boolean param_5 = obj.isEmpty();
     * boolean param_6 = obj.isFull();
     */
    // leetcode submit region end(Prohibit modification and deletion)
    public static void main(String[] args) {
        // put your test code here

    }
}
