package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class P3LongestSubstringWithoutRepeatingCharacters {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> window = new HashMap<>();
            int l = 0, r = 0;
            int len = 0;
//            HashSet<Character> window = new HashSet<>();

            while (r < s.length()) {
                char c = s.charAt(r);
                window.put(c, window.getOrDefault(c, 0) + 1);
                r++;
                while (window.get(c) > 1) {
                    char d = s.charAt(l);
                    window.put(d, window.get(d) - 1);
                    l++;
                }
                len = Math.max(len, r - l);

//                char c = s.charAt(r);
//                if (!window.contains(c)) {
//                    len = Math.max(len, r + 1 - l);
//                }
//                r++;
//                while (window.contains(c) && l < r) {
//                    char d = s.charAt(l);
//                    window.remove(d);
//                    l++;
//                }
//                window.add(c);
            }

            return len;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P3LongestSubstringWithoutRepeatingCharacters().new Solution();
        // put your test code here

    }
}
