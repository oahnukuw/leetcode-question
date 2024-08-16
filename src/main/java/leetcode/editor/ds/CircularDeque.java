package leetcode.editor.ds;

public class CircularDeque<E> {
    private CircularArray<E> circularArray;

    public CircularDeque(CircularArray<E> circularArray) {
        this.circularArray = new CircularArray<>();
    }

    // 队头增加元素 O(1)
    public void addFirst(E e) {
        circularArray.addFirst(e);
    }

    // 队尾增加元素 O(1)
    public void push(E e) {
        circularArray.addLast(e);
    }

    // 弹出对头元素 O(1)
    public E pop() {
        return circularArray.removeFirst();
    }

    // 弹出队尾元素 O(1)
    public E removeLast() {
        return circularArray.removeLast();
    }

    // 访问队头元素 O(1)
    public E peekFirst() {
        return circularArray.getFirst();
    }

    // 访问队尾元素 O(1)
    public E peekLast() {
        return circularArray.getLast();
    }

    public int size() {
        return circularArray.size();
    }

}
