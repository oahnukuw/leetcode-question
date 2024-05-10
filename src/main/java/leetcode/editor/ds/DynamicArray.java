package leetcode.editor.ds;

import java.util.NoSuchElementException;

public class DynamicArray<E> {
    private E[] array;
    private int size;
    private static final int INIT_CAPACITY = 1;

    public DynamicArray() {
        this(INIT_CAPACITY);
    }

    public DynamicArray(int initCapacity) {
        array = (E[]) new Object[initCapacity];
        size = 0;
    }

    public static void main(String[] args) {
        DynamicArray<Integer> dynamicArray = new DynamicArray<>();

        dynamicArray.addfirst(1);
        dynamicArray.append(3);
        dynamicArray.add(1, 2);
        Integer integer = dynamicArray.get(1);
        dynamicArray.remove(1);
        dynamicArray.get(1);

        for (int i = 0; i < dynamicArray.size; i++) {
            System.out.println(dynamicArray.get(i));
        }
    }

    // append an element to array
    public void append(E element) {
        int cap = array.length;
        if (size == cap) {
            resize(2 * cap);
        }
        array[size] = element;
        size++;
    }

    private void resize(int newCapacity) {
        if (size > newCapacity) {
            return;
        }
        E[] tempArray = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            tempArray[i] = array[i];
        }
        array = tempArray;
    }


    // add an element to array by index
    public void add(E element, int index) {
//        1. check positioin
        checkPositionIndex(index);
//        2. capacity is enough?
        if (size == array.length) {
            resize(2 * array.length);
        }
//        3. insert
        for (int i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = element;
        size++;
    }

    public void addfirst(E element) {
        add(element, 0);
    }

    public E removeLast() {
//        1. Is array empty?
        if (size == 0) {
            throw new NoSuchElementException();
        }
//        2. need a shrink?
        if (size == array.length / 4) {
            resize(array.length / 2);
        }

        E e = array[size - 1];
        array[size - 1] = null;
        size--;
        return e;
    }

    public E remove(int index) {
//        1. check index
        checkElementIndex(index);
//        2. need a shrink?
        if (size == array.length / 4) {
            resize(array.length / 2);
        }
//        3. remove
        E e = array[index];
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[size - 1] = null;
        size--;
        return e;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E get(int index) {
        checkElementIndex(index);
        return array[index];
    }

    public E set(E e, int index) {
        checkElementIndex(index);
        E oldVal = array[index];
        array[index] = e;
        return oldVal;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void checkPositionIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index: " + index + ", size:" + size);
        }
    }

    private void checkElementIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index: " + index + ", size:" + size);
        }
    }
}
