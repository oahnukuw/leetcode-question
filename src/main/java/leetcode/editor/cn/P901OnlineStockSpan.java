package leetcode.editor.cn;

import java.util.LinkedList;

public class P901OnlineStockSpan {

    // leetcode submit region begin(Prohibit modification and deletion)
    class StockSpanner {
        // int[]{price,maxDays}
        // Maintain a stack that the price of elements in stack are all bigger than today's price
        LinkedList<int[]> monotonicStack;

        public StockSpanner() {
            this.monotonicStack = new LinkedList<>();
        }

        public int next(int price) {
            int gap = 1;
            while (!monotonicStack.isEmpty() && monotonicStack.peek()[0] <= price) {
                int[] pop = monotonicStack.pop();
                gap += pop[1];
            }
            monotonicStack.push(new int[]{price, gap});
            return gap;
        }
    }

    /**
     * Your StockSpanner object will be instantiated and called as such:
     * StockSpanner obj = new StockSpanner();
     * int param_1 = obj.next(price);
     */
    // leetcode submit region end(Prohibit modification and deletion)
    public static void main(String[] args) {
        // put your test code here

    }
}
