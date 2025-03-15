package leetcode.editor.cn;

public class P5LongestPalindromicSubstring {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            String res="";
            for (int i = 0; i < s.length(); i++) {
                String oddString = palindrome(s, i, i);
                String evenString = palindrome(s, i, i+1);
                res = oddString.length() > res.length() ? oddString : res;
                res = evenString.length() > res.length() ? evenString : res;
            }
            return res;

        }

        private String palindrome(String s, int l, int r) {
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }
            return s.substring(l + 1, r);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P5LongestPalindromicSubstring().new Solution();
        // put your test code here

    }
}
