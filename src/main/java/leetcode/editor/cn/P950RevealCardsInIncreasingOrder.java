package leetcode.editor.cn;

import java.util.*;

public class P950RevealCardsInIncreasingOrder {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] deckRevealedIncreasing(int[] deck) {
            Arrays.sort(deck);
            Queue<Integer> queue = new LinkedList<>();
            for (int i = deck.length - 1; i >= 0; i--) {
                if (!queue.isEmpty()) {
                    queue.offer(queue.poll());
                }
                queue.offer(deck[i]);
            }
            int[] res = new int[deck.length];
            for (int i = queue.size() - 1; i >= 0; i--) {
                res[i] = queue.poll();
            }
            return res;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P950RevealCardsInIncreasingOrder().new Solution();
        // put your test code here

    }
}
