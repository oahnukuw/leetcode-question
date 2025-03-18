package leetcode.editor.cn;

public class P151ReverseWordsInAString {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseWords(String s) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c != ' ') {
                    sb.append(c);
                } else if (sb.length() != 0 && sb.charAt(sb.length() - 1) != ' ') {
                    sb.append(' ');
                }
            }
            if (sb.charAt(sb.length() - 1) == ' ') {
                sb.deleteCharAt(sb.length() - 1);
            }
            char[] chars = sb.toString().toCharArray();
            int length = chars.length;
            reverse(chars, 0, length-1);
            for (int i = 0; i < length; ) {
                for (int j = i; j < length; j++) {
                    if (j + 1 == length || chars[j + 1] == ' ') {
                        reverse(chars, i, j);
                        i = j + 2;
                        break;
                    }
                }
            }
            return new String(chars);
        }

        void reverse(char[] chars, int l, int r) {
            while (l < r) {
                char c = chars[l];
                chars[l] = chars[r];
                chars[r] = c;
                l++;
                r--;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new P151ReverseWordsInAString().new Solution();
        // put your test code here
        
    }
}
