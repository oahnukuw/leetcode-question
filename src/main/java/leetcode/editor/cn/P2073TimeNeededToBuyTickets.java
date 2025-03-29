package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.cn.common.*;

public class P2073TimeNeededToBuyTickets {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int timeRequiredToBuy(int[] tickets, int k) {
            int sum = 0;
            for (int i = 0; i < k ; i++) {
                sum += Math.min(tickets[i], tickets[k]);
            }
            for (int i = k + 1; i < tickets.length; i++) {
                sum += Math.min(tickets[i], tickets[k] - 1);
            }
            return sum += tickets[k];
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        // put your test code here
        
    }
}
