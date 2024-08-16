package leetcode.editor.ds;

public class CircularArrayQueue<E> {
    private CircularArray<E> circularArray;

    public CircularArrayQueue(CircularArray<E> circularArray) {
        this.circularArray = new CircularArray<>();
    }

    // 队尾增加元素 O(1)
    public void push(E e) {
        circularArray.addLast(e);
    }

    // 弹出对头元素 O(1)
    public E pop() {
        return circularArray.removeFirst();
    }

    // 访问队头元素 O(1)
    public E peek() {
        return circularArray.getFirst();
    }

    public int size() {
        return circularArray.size();
    }

}
