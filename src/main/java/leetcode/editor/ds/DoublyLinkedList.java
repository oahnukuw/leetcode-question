package leetcode.editor.ds;

public class DoublyLinkedList<E> {
    static class Test {

        public static void main(String[] args) {
            DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
            doublyLinkedList.addFirst(1);
            doublyLinkedList.printList();
            doublyLinkedList.add(2, 1);
            doublyLinkedList.printList();
            doublyLinkedList.add(3, 1);
            doublyLinkedList.printList();
            doublyLinkedList.remove(1);
            doublyLinkedList.printList();
            doublyLinkedList.removeLast();
            doublyLinkedList.printList();
            doublyLinkedList.printList();

        }
    }

    private static class Node<E> {
        E val;
        Node next;
        Node prev;

        public Node(Node prev, E val, Node next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }

    private final Node<E> dummyHead;
    private final Node<E> dummyLast;
    private int size;

    public DoublyLinkedList() {
        this.dummyHead = new Node<>(null, null, null);
        this.dummyLast = new Node<>(null, null, null);
        dummyHead.next = dummyLast;
        dummyLast.prev = dummyHead;
        this.size = 0;
    }

    public void printList() {
        Node node = dummyHead.next;
        for (int i = 0; i < size; i++) {
            System.out.print(node.val + ", ");
            node = node.next;
        }
        System.out.println();
    }

    // add a node into the head of the Linked List
    public void addFirst(E e) {
        Node succ = dummyHead.next;
        Node<E> newNode = new Node<>(dummyHead, e, succ);
        dummyHead.next = newNode;
        succ.prev = newNode;
        size++;
    }

    public void addLast(E e) {
        Node pred = dummyLast.prev;
        Node<E> newNode = new Node<>(pred, e, dummyLast);
        dummyLast.prev = newNode;
        pred.next = newNode;
        size++;
    }


    // add an element to linked list by index
    public void add(E e, int index) {
//        1. check positioin
        if (index < 0 || index > size) {
            return;
        }
//        2. insert
//        simplify the last node inserting
        if (size == index) {
            addLast(e);
            return;
        }
//        find the current node which will be the successor node of the new node.
        Node<E> succ = dummyHead;
//        inserting location [0,size-1] aka, allowed index
        for (int i = 0; i <= index; i++) {
            succ = succ.next;
        }
        final Node<E> pred = succ.prev;
        Node<E> newNode = new Node<>(pred, e, succ);
        pred.next = newNode;
        succ.prev = newNode;
        size++;
    }

    public E remove(int index) {
//        1. check index which includes the case of empty list (when size=0, 0 < index < size is not legal)
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index: " + index + ", size: " + size);
        }
//        2. remove
        if (index == size - 1) {
            return removeLast();
        }
        Node<E> nodeToRemove = this.dummyHead;
        for (int i = 0; i <= index; i++) {
            nodeToRemove = nodeToRemove.next;
        }
        E val = nodeToRemove.val;
        final Node<E> succ = nodeToRemove.next;
        final Node<E> pred = nodeToRemove.prev;
        pred.next = succ;
        succ.prev = pred;
        // help gc
        nodeToRemove.prev = null;
        nodeToRemove.next = null;
        nodeToRemove.val = null;
        size--;
        return val;
    }

    public E removeLast() {
        final Node<E> nodeToRemove = dummyLast.prev;
        final E val = nodeToRemove.val;
        final Node pred = nodeToRemove.prev;
        pred.next = dummyLast;
        dummyLast.prev = pred;
        nodeToRemove.prev = null;
        nodeToRemove.next = null;
        nodeToRemove.val = null;
        size--;
        return val;
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
