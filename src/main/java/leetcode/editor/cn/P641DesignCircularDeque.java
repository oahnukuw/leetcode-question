package leetcode.editor.cn;

public class P641DesignCircularDeque {

    // leetcode submit region begin(Prohibit modification and deletion)
    class MyCircularDeque {

        MyArrayQueue<Integer> arrayQueue;
        int maxCap;
        public MyCircularDeque(int k) {
            arrayQueue = new MyArrayQueue<>();
            maxCap = k;

        }

        public boolean insertFront(int value) {
            if (arrayQueue.size == maxCap) {
                return false;
            }
            arrayQueue.addFirst(value);
            return true;
        }

        public boolean insertLast(int value) {
            if (arrayQueue.size == maxCap) {
                return false;
            }
            arrayQueue.addLast(value);
            return true;
        }

        public boolean deleteFront() {
            return arrayQueue.deleteFront() != null;
        }

        public boolean deleteLast() {
            return arrayQueue.deleteLast() != null;
        }

        public int getFront() {
            Integer result = arrayQueue.peekFirst();
            return result == null ? -1 : result;

        }

        public int getRear() {
            Integer result = arrayQueue.peekLast();
            return result == null ? -1 : result;
        }

        public boolean isEmpty() {
            return arrayQueue.size == 0;

        }

        public boolean isFull() {
            return arrayQueue.size == maxCap;

        }
    }

    class MyArrayQueue<E> {
        private final static int INIT_CAP = 4;
        Object[] elements;
        int head, tail;
        int size;
        int capacity;

        public MyArrayQueue() {
            this(INIT_CAP);
        }

        public MyArrayQueue(int capacity) {
            elements = new Object[capacity];
            size = 0;
            this.capacity = capacity;
            head = tail = 0;
        }

        private void resize(int newCap) {
            Object[] a = new Object[newCap];
            for (int i = 0; i < this.size; i++) {
                a[i] = elements[(head + i) & this.capacity - 1];
            }
            head = 0;
            tail = this.size;
            this.capacity = newCap;
            elements = a;
        }

        public void addFirst(E value) {
            if (this.size == capacity) {
                resize(this.size * 2);
            }
            elements[head = (head - 1) & (this.capacity - 1)] = value;
            size++;
        }

        public void addLast(E value) {
            if (this.size == capacity) {
                resize(this.size * 2);
            }
            elements[tail] = value;
            tail = (tail + 1) & (this.capacity - 1);
            size++;
        }

        public E deleteFront() {
            int h = head;
            E result = (E) elements[h];
            if (result == null) {
                return null;
            }
            elements[h] = null;
            head = (head + 1) & (capacity - 1);
            size--;
            if (size < capacity / 4) {
                resize(capacity / 2);
            }
            return result;

        }

        public E deleteLast() {
            int t = (tail - 1) & (capacity - 1);
            E result = (E) elements[t];
            if (result == null) {
                return null;
            }
            size--;
            elements[t] = null;
            tail = t;
            if (size < capacity / 4) {
                resize(capacity / 2);
            }
            return result;

        }

        public E peekFirst() {
            return (E) elements[head];

        }

        public E peekLast() {
            return (E) elements[(tail - 1) & (capacity - 1)];
        }

    }

    /**
     * Your MyCircularDeque object will be instantiated and called as such:
     * MyCircularDeque obj = new MyCircularDeque(k);
     * boolean param_1 = obj.insertFront(value);
     * boolean param_2 = obj.insertLast(value);
     * boolean param_3 = obj.deleteFront();
     * boolean param_4 = obj.deleteLast();
     * int param_5 = obj.getFront();
     * int param_6 = obj.getRear();
     * boolean param_7 = obj.isEmpty();
     * boolean param_8 = obj.isFull();
     */
    // leetcode submit region end(Prohibit modification and deletion)
    public static void main(String[] args) {
        // put your test code here

    }
}
