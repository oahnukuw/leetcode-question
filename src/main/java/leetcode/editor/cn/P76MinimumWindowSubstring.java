
//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
//
// 
//
// 注意： 
//
// 
// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 示例 3: 
//
// 
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 10⁵ 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 
//o(n) 时间内解决此问题的算法吗？
//
// Related Topics哈希表 | 字符串 | 滑动窗口 
//
// 👍 2224, 👎 0 
//
//
//
//


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class P76MinimumWindowSubstring {
    public static void main(String[] args) {
        Solution solution = new P76MinimumWindowSubstring().new Solution();
        String s = "a", t="a";
        System.out.println(solution.minWindow(s, t));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            Map<Character, Integer> need = new HashMap<>();
            Map<Character, Integer> window = new HashMap<>();

            for(int i=0; i<t.length(); i++){
                char c = t.charAt(i);
                need.put(c, need.getOrDefault(c, 0)+1);
            }

            int left = 0, right = 0, start = 0, length = Integer.MAX_VALUE, valid = 0;

            while(right<s.length()){
                char c = s.charAt(right);
                right++;
                // window only stores the character in the need
                if(need.containsKey(c)){
                    window.put(c, window.getOrDefault(c, 0)+1);
                    if(need.get(c).equals(window.get(c))){
                        valid++;
                    }
                }

                while(need.size() == valid){
                    if(right - left < length){
                        length = right - left;
                        start = left;
                    }

                    char d = s.charAt(left);
                    left++;
                    if(need.containsKey(d)){
                        if(need.get(d).equals(window.get(d))){
                            valid--;
                        }
                        window.put(d, window.get(d)-1);
                    }
                }

            }
            return length == Integer.MAX_VALUE? "":s.substring(start, start+length);
//            // record what character and count of it is needed for solution
//            Map<Character, Integer> need = new HashMap<>(1 << 1);
//            // record the count of effective character in the window
//            Map<Character, Integer> window = new HashMap<>(1 << 1);
//            for (int i = 0; i < t.length(); i++) {
//                char ct = t.charAt(i);
//                need.put(ct, need.getOrDefault(ct, 0) + 1);
//            }
//            // for judge whether the window still have vaild solution
//            int valid = 0;
//            // window margin point
//            int left = 0;
//            int right = 0;
//            // pointer for solution
//            int start = 0, len = Integer.MAX_VALUE;
//            while (right < s.length()) {
//                // get the character for window
//                char c = s.charAt(right);
//                // enlarge window
//                right++;
//                if (need.containsKey(c)) {
//                    // record the aimed character into window
//                    window.put(c, window.getOrDefault(c, 0) + 1);
//                    if (need.get(c).equals(window.get(c))) {
//                        valid++;
//                    }
//                }
//
//                // shrink the window until window is not valid
//                while (valid == need.size()) {
//                    // 1. update the solution with effective window
//                    if (right - left < len) {
//                        start = left;
//                        len = right - left;
//                    }
//                    // 2. shrink the window
//                    // the character is gonna out of window
//                    char d = s.charAt(left);
//                    left++;
//                    if (need.containsKey(d)) {
//                        // update effective data of window
//                        if (need.get(d).equals(window.get(d))) {
//                            valid--;
//                        }
//                        window.put(d, window.get(d) - 1);
//                    }
//                }
//            }
//            return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}