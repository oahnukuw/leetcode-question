
  //给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。 
//
// 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
// 
//
// 示例 2: 
//
// 
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, p.length <= 3 * 10⁴ 
// s 和 p 仅包含小写字母 
// 
//
// Related Topics哈希表 | 字符串 | 滑动窗口 
//
// 👍 1039, 👎 0 
//
//
//
//

  
  package leetcode.editor.cn;

  import java.util.ArrayList;
  import java.util.HashMap;
  import java.util.List;
  import java.util.Map;

  public class P438FindAllAnagramsInAString{
      public static void main(String[] args) {
           Solution solution = new P438FindAllAnagramsInAString().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        // Maintain a window with index [left, right)

        // record the count of each letter that is needed
        Map<Character, Integer> need = new HashMap<>();

        // init the map of needed letter
        for(int i=0; i<p.length(); i++){
            char ct = p.charAt(i);
            need.put(ct, need.getOrDefault(ct, 0)+1);
        }

        // record the count of needed letters in window
        Map<Character, Integer> window = new HashMap<>();

        int left = 0, right = 0;
        int valid = 0;
        // record the index of result
        List<Integer> resultList = new ArrayList<>();

        // Enlarge window when right index is less than length of string s. Update the count of valid letter.
        while(right < s.length()){
            // update the count of valid letter in window
            char c = s.charAt(right);
            if(need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0)+1);
                // Increase valid when the count of letter in need is equal the count of the letter in window
                if(need.get(c).equals(window.get(c))){
                    valid++;
                }
            }

            // enlarge window
            right++;
        // Shrink window when the count of valid letter is equal to the size of letters that string p needs. Update result.
            while(right - left >= p.length()){
                if(valid == need.size()){
                    resultList.add(left);
                }
                // letter is gonna out of window
                char d = s.charAt(left);
                // update the valid letter in window
                if(need.containsKey(d)){
                    if(need.get(d).equals(window.get(d))){
                        valid--;
                    }
                    window.put(d, window.get(d)-1);
                }
                // shrink window
                left++;
            }
        }
        return resultList;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }