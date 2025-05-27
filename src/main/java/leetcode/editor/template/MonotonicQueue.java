package leetcode.editor.template;

import java.util.LinkedList;

class MonotonicQueue {
    LinkedList<Integer> q;
    LinkedList<Integer> maxQueue;
    LinkedList<Integer> minQueue;

    public MonotonicQueue() {
        q = new LinkedList<>();
        maxQueue = new LinkedList<>();
        minQueue = new LinkedList<>();
    }

    public void push(Integer elem) {
        // push to normal queue
        q.addLast(elem);

        // push to maxQueue
        while (!maxQueue.isEmpty() && maxQueue.peekLast() < elem) {
            maxQueue.pollLast();
        }
        maxQueue.addLast(elem);

        // push to minQueue
        while (!minQueue.isEmpty() && minQueue.peekLast() > elem) {
            minQueue.pollLast();
        }
        minQueue.addLast(elem);
    }

    public Integer pop() {
        if (q.isEmpty()) {
            return null;
        }
        Integer delValue = q.pop();

        if (delValue.equals(maxQueue.getFirst())) {
            maxQueue.pollFirst();
        }

        if (delValue.equals(minQueue.getFirst())) {
            minQueue.pollFirst();
        }
        return delValue;
    }

    public Integer max() {
        return maxQueue.peekFirst();
    }

    public Integer min() {
        return minQueue.peekFirst();
    }

    public int size() {
        return q.size();
    }

    public boolean isEmpty() {
        return q.isEmpty();
    }

}
