package leetcode.editor.ds;

/*
Achievement with a dummy head node and a tail node. The dummy head node ensures consistency in insertion at the head of the linked list, while the tail node reduce the time consumption of insertion at the last of the linked list.
In an empty list, the tail node points to the dummy head.
Compared to the singly linked list only has dummy head, adding an element to an empty list and removing an element of  the last element of the linked list with a tail node pointer needs to reassign the tail node pointer.
 */
public class SinglyLinkedList<E> {

    private static class Node<E> {
        E val;
        Node next;

        public Node(E val) {
            this.val = val;
            this.next = null;
        }
    }

    private final Node<E> dummyHead;
    // Actual tail node of the linked list
    private Node<E> tail;
    private int size;

    public SinglyLinkedList() {
        this.dummyHead = new Node<>(null);
        this.tail = dummyHead;
        this.size = 0;
    }

    // add a node into the head of the Linked List
    public void addFirst(E e) {
//        Node<E> newNode = new Node<>(e);
//        newNode.next = dummyHead.next;
//        dummyHead.next = newNode;
//        if (size == 0) {
//            tail = newNode;
//        }
//        size++;
        this.add(e, 0);
    }

    public void addLast(E e) {
        Node<E> newNode = new Node<>(e);
        tail.next = newNode;
        tail = newNode;
        size++;
    }


    // add an element to linked list by index
    public void add(E e, int index) {
//        1. check positioin
        if (index < 0 || index > size) {
            return;
        }
//        2. insert
        if (size == index) {
            addLast(e);
            return;
        }
        Node<E> prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node<E> newNode = new Node<>(e);
        newNode.next = prev.next;
        prev.next = newNode;
        size++;
    }

    public E remove(int index) {
//        1. check index which includes the case of empty list (when size=0, 0 < index < size is not legal)
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index: " + index + ", size: " + size);
        }
//        2. remove
        Node<E> prev = this.dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node<E> temp = prev.next;
        prev.next = temp.next;
        if (size - 1 == index) {
            tail = prev;
        }
        size--;
        return temp.val;
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public E removeFirst() {
        return remove(0);
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index: " + index + ", size: " + size);
        }
        Node<E> p = this.dummyHead;
        for (int i = 0; i <= index; i++) {
            p = p.next;
        }
        return p.val;
    }

    public E set(E e, int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index: " + index + ", size: " + size);
        }
        Node<E> p = this.dummyHead;
        for (int i = 0; i <= index; i++) {
            p = p.next;
        }
        E oldVal = p.val;
        p.val = e;
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
