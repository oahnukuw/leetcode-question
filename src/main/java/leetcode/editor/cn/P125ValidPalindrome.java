package leetcode.editor.cn;

public class P125ValidPalindrome {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {
//            char[] lowS = s.toCharArray();
//            int slow=0, fast=0;
//            while (fast < lowS.length) {
//                if ((lowS[fast] >= 'a' && lowS[fast] <= 'z') || (lowS[fast] >= 'A' && lowS[fast] <= 'Z') || (lowS[fast] >= '0' && lowS[fast] <= '9')) {
//                    if (lowS[fast] >= 'A' && lowS[fast] <= 'Z') {
//                        lowS[slow] = (char) (lowS[fast] + 32);
//                    } else {
//                        lowS[slow] = lowS[fast];
//                    }
//                    slow++;
//                }
//                fast++;
//            }
//            int l = 0, r = slow - 1;
//            while (l < r) {
//                if (lowS[l] != lowS[r]) {
//                    return false;
//                }
//                l++;
//                r--;
//            }
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (Character.isLetterOrDigit(c)) {
                    sb.append(Character.toLowerCase(c));
                }
            }
            s=sb.toString();
            int l = 0, r = s.length() - 1;
            while (l < r) {
                if (s.charAt(l) != s.charAt(r)) {
                    return false;
                }
                l++; r--;
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new P125ValidPalindrome().new Solution();
        // put your test code here
        String s = "A man, a plan, a canal: Panama";
        solution.isPalindrome(s);
        
    }
}
