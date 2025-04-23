package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P131PalindromePartitioning {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        LinkedList<String> track = new LinkedList<>();
        List<List<String>> res = new ArrayList<>();

        public List<List<String>> partition(String s) {
            backtrack(s, 0);
            return res;
        }

        private void backtrack(String s, int start) {
            if (start == s.length()) {
                res.add(new ArrayList<>(track));
            }

            for (int i = start; i < s.length(); i++) {
                if (!isPalindrome(s, start, i)) {
                    continue;
                }
                track.add(s.substring(start, i + 1));
                backtrack(s, i + 1);
                track.removeLast();
            }
        }

        private boolean isPalindrome(String s, int begin, int end) {
            int lo = begin, hi = end;
            while (lo < hi) {
                if (s.charAt(lo) != s.charAt(hi)) {
                    return false;
                }
                lo++;
                hi--;
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
