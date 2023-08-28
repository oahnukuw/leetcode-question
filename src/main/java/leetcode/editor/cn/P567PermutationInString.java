
  //给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。 
//
// 换句话说，s1 的排列之一是 s2 的 子串 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s1 = "ab" s2 = "eidbaooo"
//输出：true
//解释：s2 包含 s1 的排列之一 ("ba").
// 
//
// 示例 2： 
//
// 
//输入：s1= "ab" s2 = "eidboaoo"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length, s2.length <= 10⁴ 
// s1 和 s2 仅包含小写字母 
// 
//
// Related Topics哈希表 | 双指针 | 字符串 | 滑动窗口 
//
// 👍 786, 👎 0 
//
//
//
//

  
  package leetcode.editor.cn;

  import java.util.HashMap;
  import java.util.Map;

  public class P567PermutationInString{
      public static void main(String[] args) {
           Solution solution = new P567PermutationInString().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // Maintain a window with dynamic adjustment to find the solution. the boundary of window is [left, right).
        int left = 0, right = 0;
        int valid = 0;
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for(int i=0; i<s1.length(); i++){
            char ct = s1.charAt(i);
            need.put(ct, need.getOrDefault(ct, 0)+1);
        }

        // Enlarge the window until the right pointer exceed the boundary of s2 array.
        while(right < s2.length()){
            // get the character which is going to enter in window
            char c = s2.charAt(right);
            // enlarge window size
            right++;
            if(need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0)+1);
                // calculate the valid character of window
                if(need.get(c).equals(window.get(c))){
                    valid++;
                }
            }

        // Shrink the window when window's length is bigger than the length of string s1
            while(valid == need.size()){
                if(right - left == s1.length()){
                    return true;
                }
                char d = s2.charAt(left);
                left++;
                if(need.containsKey(d)){
                    if(need.get(d).equals(window.get(d))){
                        valid--;
                    }
                    window.put(d, window.get(d)-1);
                }
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }