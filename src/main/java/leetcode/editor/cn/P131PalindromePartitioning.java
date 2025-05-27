package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P131PalindromePartitioning {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<String>> res;
        LinkedList<String> track;

        public List<List<String>> partition(String s) {
            res = new ArrayList<>();
            track = new LinkedList<>();
            backtrack(s);
            return res;
        }

        private void backtrack(String s) {
            if (s.isEmpty()) {
                res.add(new ArrayList<>(track));
                return;
            }
            for (int i = 0; i < s.length(); i++) {
                String substring = s.substring(0, i + 1);
                if (isPalindrome(substring)) {
                    track.addLast(substring);
                    backtrack(s.substring(i + 1));
                    track.removeLast();
                }
            }
        }

        private boolean isPalindrome(String s) {
            int left = 0, right = s.length() - 1;
            while (left < right) {
                if (s.charAt(left++) != s.charAt(right--)) {
                    return false;
                }
            }
            return true;
        }


    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P131PalindromePartitioning().new Solution();
        // put your test code here

    }
}
