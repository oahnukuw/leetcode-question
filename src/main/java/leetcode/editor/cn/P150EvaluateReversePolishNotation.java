package leetcode.editor.cn;

import java.util.Stack;

public class P150EvaluateReversePolishNotation {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int evalRPN(String[] tokens) {
            Stack<Integer> numbers = new Stack<>();
            for (String token : tokens) {
                Operation operation = Operation.fromString(token);
                if (operation != null) {
                    Integer n2 = numbers.pop();
                    Integer n1 = numbers.pop();
                    switch (operation) {
                        case PLUS:
                            numbers.push(n1 + n2);
                            break;
                        case MULTIPLY:
                            numbers.push(n1 * n2);
                            break;
                        case MINUS:
                            numbers.push(n1 - n2);
                            break;
                        case DIVIDE:
                            numbers.push(n1 / n2);
                            break;
                        default:
                    }
                } else {
                    numbers.push(Integer.valueOf(token));
                }
            }
            return numbers.pop();
        }

    }

    enum Operation {
        PLUS("+"),
        MULTIPLY("*"),
        MINUS("-"),
        DIVIDE("/");

        private final String value;

        Operation(final String value) {
            this.value = value;
        }

        private String getValue() {
            return this.value;
        }

        public static Operation fromString(String s) {
            for (Operation op : Operation.values()) {
                if (op.getValue().equals(s)) {
                    return op;
                }
            }
            return null;
        }

    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P150EvaluateReversePolishNotation().new Solution();
        // put your test code here

    }
}
