package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P901OnlineStockSpan {

    // leetcode submit region begin(Prohibit modification and deletion)
    class StockSpanner {
        Stack<int[]> s;

        public StockSpanner() {
            s = new Stack<>();
        }

        public int next(int price) {
            int count = 1;
            while (!s.isEmpty() && price >= s.peek()[0]) {
                count += s.pop()[1];
            }
            s.push(new int[]{price, count});
            return count;
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
