
  //给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
//
// Related Topics字符串 | 动态规划 
//
// 👍 5872, 👎 0 
//
//
//
//

  
  package leetcode.editor.cn;

  public class P5LongestPalindromicSubstring{
      public static void main(String[] args) {
           Solution solution = new P5LongestPalindromicSubstring().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        for(int i=0; i<s.length(); i++){
            String s1 = palindrome(s, i, i);
            String s2 = palindrome(s, i, i+1);
            res = res.length()>s1.length()? res : s1;
            res = res.length()>s2.length()? res : s2;
        }
        return res;
    }

    private String palindrome(String s, int l, int r){
        // Judge of palindrome can from the center of string to both side of string edge
        while(l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l+1, r);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }