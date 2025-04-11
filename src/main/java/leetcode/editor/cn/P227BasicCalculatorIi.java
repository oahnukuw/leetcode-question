package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Stack;

public class P227BasicCalculatorIi {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int calculate(String s) {
            HashMap<Integer, Integer> rightParenIndex = new HashMap<>();
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(') {
                    stack.push(i);
                }
                if (c == ')') {
                    rightParenIndex.put(stack.pop(), i);
                }
            }
            return calc(s, 0, s.length() - 1, rightParenIndex);
        }

        private int calc(String s, int begin, int end, HashMap<Integer, Integer> rightParenIndex) {
            Stack<Integer> stack = new Stack<>();
            int num = 0;
            char sign = '+';
            for (int i = begin; i <= end; i++) {
                char c = s.charAt(i);
                if (c >= '0' && c <= '9') {
                    num = num * 10 + (c - '0');
                }
                if (c == '(') {
                    num = calc(s, i + 1, rightParenIndex.get(i) - 1, rightParenIndex);
                    i = rightParenIndex.get(i);
                }
                // sign is a delimiter
                if (c == '+' || c == '-' || c == '*' || c == '/' || i == s.length() - 1) {
                    switch (sign) {
                        case '+':
                            stack.push(num);
                            break;
                        case '-':
                            stack.push(-num);
                            break;
                        case '*':
                            stack.push(stack.pop() * num);
                            break;
                        case '/':
                            stack.push(stack.pop() / num);
                            break;
                    }
                    sign = c;
                    num = 0;
                }
            }
            int res = 0;
            while (!stack.isEmpty()) {
                res += stack.pop();
            }
            return res;
        }

    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P227BasicCalculatorIi().new Solution();
        // put your test code here

    }
}
