package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P17LetterCombinationsOfAPhoneNumber {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        char[][] map = new char[][]{{}, {},
                {'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'},
                {'j', 'k', 'l'},
                {'m', 'n', 'o'},
                {'p', 'q', 'r', 's'},
                {'t', 'u', 'v'},
                {'w', 'x', 'y', 'z'},
        };
        List<String> res = new ArrayList<>();
        StringBuilder track = new StringBuilder();

        public List<String> letterCombinations(String digits) {
            if (digits.isEmpty()) {
                return res;
            }
            backtrack(digits, 0);
            return res;
        }

        private void backtrack(String digits, int index) {
            if (digits.length() == index) {
                res.add(track.toString());
                return;
            }
            char[] chars = map[digits.charAt(index) - '0'];
            for (char aChar : chars) {
                track.append(aChar);
                backtrack(digits, index + 1);
                track.deleteCharAt(track.length() - 1);
            }
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P17LetterCombinationsOfAPhoneNumber().new Solution();
        // put your test code here

    }
}
