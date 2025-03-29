package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Queue;

public class P225ImplementStackUsingQueues {

    // leetcode submit region begin(Prohibit modification and deletion)
    class MyStack {
        private final Queue<Integer> queue = new ArrayDeque<>();
        private int topElement = 0;

        public MyStack() {
        }

        public void push(int x) {
            topElement = x;
            queue.offer(x);
        }

        public int pop() {
            int size = queue.size();
            while (size > 2) {
                queue.offer(queue.poll());
                size--;
            }
            topElement = queue.peek();
            queue.offer(queue.poll());
            return queue.poll();
        }

        public int top() {
            return topElement;
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }

    /**
     * Your MyStack object will be instantiated and called as such:
     * MyStack obj = new MyStack();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.top();
     * boolean param_4 = obj.empty();
     */
    // leetcode submit region end(Prohibit modification and deletion)
    public static void main(String[] args) {
        // put your test code here

    }
}
