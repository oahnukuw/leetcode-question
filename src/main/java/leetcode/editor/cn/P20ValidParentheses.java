package leetcode.editor.cn;

import java.util.Stack;

public class P20ValidParentheses {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            Stack<Character> leftSign = new Stack<>();
            for (char c : s.toCharArray()) {
                if (c == '[' || c == '{' || c == '(') {
                    leftSign.push(c);
                } else {
                    if (!leftSign.isEmpty() && leftSign.peek() == leftOfC(c)) {
                        leftSign.pop();
                    } else {
                        return false;
                    }
                }
            }
            return leftSign.isEmpty();
        }

        private char leftOfC(char c) {
            if (c == ']') {
                return '[';
            }
            if (c == '}') {
                return '{';
            }
            return '(';
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P20ValidParentheses().new Solution();
        // put your test code here

    }
}
