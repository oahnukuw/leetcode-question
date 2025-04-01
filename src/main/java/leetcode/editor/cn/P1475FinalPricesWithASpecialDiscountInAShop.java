package leetcode.editor.cn;

import java.util.Stack;

public class P1475FinalPricesWithASpecialDiscountInAShop {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] finalPrices(int[] prices) {
            int n = prices.length;
            int[] res = new int[n];
            Stack<Integer> s = new Stack<>();
            for (int i = n - 1; i >= 0; i--) {
                int price = prices[i];
                while (!s.isEmpty() && s.peek() > price) {
                    s.pop();
                }
                res[i] = s.isEmpty() ? price : price - s.peek();
                s.push(price);
            }
            return res;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P1475FinalPricesWithASpecialDiscountInAShop().new Solution();
        // put your test code here

    }
}
