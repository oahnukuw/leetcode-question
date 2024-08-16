package leetcode.editor.ds;

public class circularArray<T> {
    private T[] arr;
    // point to the first element
    private int head;
    // point to the next of the last element
    private int tail;
    // the actual size of the array
    private int size;
    // the capacity of the array
    private int capacity;

    public circularArray() {
        this(2);
    }

    public circularArray(int capacity) {
        // capacity should be power of 2
        this.arr = (T[]) new Object[capacity];
        this.head = 0;
        this.tail = 0;
        this.size = 0;
        this.capacity = capacity;
    }

    private void resize(int capacity) {
        // new capacity should be power of 2
        T[] newArray = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = arr[(head + i) & (this.capacity - 1)];
        }
        arr = newArray;
        head = 0;
        tail = this.size;
        this.capacity = capacity;
    }

    public void addFirst(T e) {
        if (isfull()) {
            resize(capacity * 2);
        }
        arr[head = (head - 1) & (capacity - 1)] = e;
        size++;
    }

    public void addLast(T e) {
        if (isfull()) {
            resize(capacity * 2);
        }
        arr[tail & (this.capacity - 1)] = e;
        tail = (tail + 1) & (this.capacity - 1);
        size++;
    }

    public boolean isfull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

}
