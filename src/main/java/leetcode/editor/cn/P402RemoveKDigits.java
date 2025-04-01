package leetcode.editor.cn;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class P402RemoveKDigits {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String removeKdigits(String num, int k) {
            char[] chars = num.toCharArray();
            Stack<Character> s = new Stack<>();
            for (char c : chars) {
                while (!s.isEmpty() && c < s.peek() && k > 0) {
                    s.pop();
                    k--;
                }
                if (s.isEmpty() && c == '0') {
                    continue;
                }
                s.push(c);
            }

            while (k > 0 && !s.isEmpty()) {
                s.pop();
                k--;
            }

            if (s.isEmpty()) {
                return "0";
            }

            StringBuilder sb = new StringBuilder();
            while (!s.isEmpty()) {
                sb.append(s.pop());
            }
            return sb.reverse().toString();

        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P402RemoveKDigits().new Solution();
        // put your test code here

    }
}
