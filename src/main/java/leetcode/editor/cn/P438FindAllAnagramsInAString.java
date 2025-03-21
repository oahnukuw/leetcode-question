package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P438FindAllAnagramsInAString {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            int l = 0, r = 0;
            Map<Character, Integer> windows = new HashMap<>();
            Map<Character, Integer> needs = new HashMap<>();
            int find = 0;
            List<Integer> res = new ArrayList<>();

            for (char c : p.toCharArray()) {
                needs.put(c, needs.getOrDefault(c, 0) + 1);
            }

            while (r < s.length()) {
                char c = s.charAt(r);
                if (needs.containsKey(c)) {
                    windows.put(c, windows.getOrDefault(c, 0) + 1);
                    if (windows.get(c).equals(needs.get(c))) {
                        find++;
                    }
                }
                r++;

                if ((r - l) == p.length()) {
                    char d = s.charAt(l);
                    if (find == needs.size()) {
                        res.add(l);
                    }
                    if (needs.containsKey(d)) {
                        if (needs.get(d).equals(windows.get(d))) {
                            find--;
                        }
                        windows.put(d, windows.get(d) - 1);
                    }
                    l++;
                }
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P438FindAllAnagramsInAString().new Solution();
        // put your test code here

    }
}
