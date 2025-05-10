package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class P241DifferentWaysToAddParentheses {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        HashMap<String, List<Integer>> memo = new HashMap<>();

        public List<Integer> diffWaysToCompute(String expression) {
            if (memo.containsKey(expression)) {
                return memo.get(expression);
            }
            ArrayList<Integer> result = new ArrayList<>();
            for (int i = 0; i < expression.length(); i++) {
                char c = expression.charAt(i);
                if (c == '+' || c == '-' || c == '*') {
                    List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                    List<Integer> right = diffWaysToCompute(expression.substring(i + 1));
                    for (Integer a : left) {
                        for (Integer b : right) {
                            switch (c) {
                                case '+':
                                    result.add(a + b);
                                    break;
                                case '-':
                                    result.add(a - b);
                                    break;
                                case '*':
                                    result.add(a * b);
                                    break;
                            }
                        }
                    }
                }
            }
            if (result.isEmpty()) {
                result.add(Integer.valueOf(expression));
            }
            memo.put(expression, result);
            return result;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P241DifferentWaysToAddParentheses().new Solution();
        // put your test code here
        solution.diffWaysToCompute("2-1-1");

    }
}
