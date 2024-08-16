package leetcode.editor.ds;

import java.util.ArrayList;

public class ArrayStack<E> {
    private ArrayList<E> arrayList = new ArrayList<>();

    //    栈顶加入元素
    public void push(E e) {
        arrayList.add(e);
    }

    // 推出栈顶元素
    public E pop() {
        return arrayList.remove(arrayList.size() - 1);
    }

    // 访问栈顶元素
    public E peek() {
        return arrayList.get(arrayList.size() - 1);
    }

    //    返回栈元素个数
    public int size() {
        return arrayList.size();
    }

}
