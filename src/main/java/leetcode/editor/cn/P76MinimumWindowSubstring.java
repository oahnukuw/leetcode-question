package leetcode.editor.cn;

import java.util.HashMap;

public class P76MinimumWindowSubstring {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            // Define window [left,right) is the subString of s which only contains chars of t
            // Enlarge the window when right<s.length shrink when t in the window
            int left = 0, right = 0;
            // Record how many chars of t were met in window
            HashMap<Character, Integer> target = new HashMap<>();
            for (int i = 0; i < t.length(); i++) {
                char c = t.charAt(i);
                target.put(c, target.getOrDefault(c, 0) + 1);
            }
            int noFound = target.size();
            HashMap<Character, Integer> window = new HashMap<>();
            int start = 0, end = s.length() + 1;
            while (right < s.length()) {
                char c = s.charAt(right);
                if (target.containsKey(c)) {
                    window.put(c, window.getOrDefault(c, 0) + 1);
                    if (window.get(c).equals(target.get(c))) {
                        noFound--;
                    }
                }
                right++;

                while (noFound == 0 && left < right) {
                    char d = s.charAt(left);
                    if (( end-start )>(right-left)){
                        end = right;
                        start = left;
                    }
                        if (target.containsKey(d)) {
                            if (window.get(d).equals(target.get(d))) {
                                noFound++;
                        }
                            window.put(d, window.get(d) - 1);
                    }
                    left++;
                }
            }
            return end == s.length() + 1 ? "" : s.substring(start, end);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P76MinimumWindowSubstring().new Solution();
        // put your test code here
        String s = "aa", t = "aa";
        solution.minWindow(s, t);

    }
}
