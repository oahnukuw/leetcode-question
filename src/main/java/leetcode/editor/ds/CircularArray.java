package leetcode.editor.ds;

import java.util.NoSuchElementException;

public class CircularArray<E> {
    private E[] arr;
    // point to the first element
    private int head;
    // point to the next of the last element
    private int tail;
    // the actual size of the array
    private int size;
    // the capacity of the array
    private int capacity;

    public CircularArray() {
        this(2);
    }

    public CircularArray(int capacity) {
        // capacity should be power of 2
        this.arr = (E[]) new Object[capacity];
        this.head = 0;
        this.tail = 0;
        this.size = 0;
        this.capacity = capacity;
    }

    private void resize(int capacity) {
        // new capacity should be power of 2
        E[] newArray = (E[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = arr[(head + i) & (this.capacity - 1)];
        }
        arr = newArray;
        head = 0;
        tail = this.size;
        this.capacity = capacity;
    }

    public void addFirst(E e) {
        if (isFull()) {
            resize(capacity * 2);
        }
        arr[head = (head - 1) & (capacity - 1)] = e;
        size++;
    }

    public E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Array is empty");
        }
        E e = arr[head];
        arr[head] = null;
        head = (head + 1) & (capacity - 1);
        size--;
        return e;
    }

    public void addLast(E e) {
        if (isFull()) {
            resize(capacity * 2);
        }
        arr[tail & (this.capacity - 1)] = e;
        tail = (tail + 1) & (this.capacity - 1);
        size++;
    }

    public E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Array is empty");
        }
        tail = (tail - 1) & (capacity - 1);
        E e = arr[tail];
        arr[tail] = null;
        size--;
        return e;
    }

    public E getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Array is empty");
        }
        return arr[head];
    }

    public E getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Array is empty");
        }
        return arr[(tail - 1) & (capacity - 1)];
    }

    public int size() {
        return size;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

}
