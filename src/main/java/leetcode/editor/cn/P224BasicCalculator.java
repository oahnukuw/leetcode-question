package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Stack;

public class P224BasicCalculator {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int calculate(String s) {
            HashMap<Integer, Integer> rightParIndex = new HashMap<>();
            Stack<Integer> stack = new Stack<>();
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                if (c == '(') {
                    stack.push(i);
                }
                if (c == ')') {
                    rightParIndex.put(stack.pop(), i);
                }
            }
            return calc(s, 0, s.length() - 1, rightParIndex);
        }

        private int calc(String s, int begin, int end, HashMap<Integer, Integer> rightParIndex) {
            char sign = '+';
            int num = 0;
            Stack<Integer> stack = new Stack<>();
            for (int i = begin; i <= end; i++) {
                char c = s.charAt(i);
                if (c >= '0' && c <= '9') {
                    num = 10 * num + (c - '0');
                }
                if (c == '(') {
                    num = calc(s, i + 1, rightParIndex.get(i) - 1, rightParIndex);
                    i = rightParIndex.get(i);
                }
                if (c == '+' || c == '-' || c == '*' || c == '/' || i == end) {
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
        // put your test code here

    }
}
