package leetcode.editor.cn;

import java.util.HashMap;

public class P76MinimumWindowSubstring {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            int l = 0, r = 0;
            HashMap<Character, Integer> windows = new HashMap<>();
            HashMap<Character, Integer> needs = new HashMap<>();
            int find = 0;
            for (char c : t.toCharArray()) {
                needs.put(c, needs.getOrDefault(c, 0) + 1);
            }

            int minlen = Integer.MAX_VALUE;
            int start = 0;
            while (r < s.length()) {
                Character rChar = s.charAt(r);
                if (needs.containsKey(rChar)) {
                    windows.put(rChar, windows.getOrDefault(rChar, 0) + 1);
                    if (windows.get(rChar).equals(needs.get(rChar))) {
                        find++;
                    }
                }
                r++;

                while (l < r && find == needs.size()) {
                    if ((r - l) < minlen) {
                        // update answer
                        minlen = r - l;
                        start = l;
                    }
                    char lChar = s.charAt(l);
                    if (needs.containsKey(lChar)) {
                        if (needs.get(lChar).equals(windows.get(lChar))) {
                            find--;
                        }
                        windows.put(lChar, windows.get(lChar) - 1);
                    }
                    l++;
                }
            }
            return minlen == Integer.MAX_VALUE ? "" : s.substring(start, start + minlen);
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
