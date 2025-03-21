package leetcode.editor.cn;

import java.util.HashMap;

public class P567PermutationInString {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            int l = 0, r = 0;
            HashMap<Character, Integer> needs = new HashMap<>();
            HashMap<Character, Integer> windows = new HashMap<>();
            for (char c : s1.toCharArray()) {
                needs.put(c, needs.getOrDefault(c, 0) + 1);
            }
            int find = 0;
            while (r < s2.length()) {
                char c = s2.charAt(r);
                if (needs.containsKey(c)) {
                    windows.put(c, windows.getOrDefault(c, 0) + 1);
                    if (needs.get(c).equals(windows.get(c))) {
                        find++;
                    }
                }
                if (find == needs.size()) {
                    return true;
                }
                r++;

                while ((r - l) >= s1.length()) {
                    char d = s2.charAt(l);
                    if (needs.containsKey(d)) {
                        if (needs.get(d).equals(windows.get(d))) {
                            find--;
                        }
                        windows.put(d, windows.get(d) - 1);
                    }
                    l++;
                }
            }
            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P567PermutationInString().new Solution();
        // put your test code here
        String s = "ab", t = "boa";
        solution.checkInclusion(s, t);
    }
}
