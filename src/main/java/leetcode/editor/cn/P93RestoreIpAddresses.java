package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P93RestoreIpAddresses {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> res = new ArrayList<>();
        LinkedList<String> track = new LinkedList<>();

        public List<String> restoreIpAddresses(String s) {
            backtrack(s, 0);
            return res;
        }

        private void backtrack(String s, int start) {
            if (track.size() > 4) {
                return;
            }

            if (start == s.length() && track.size() == 4) {
                res.add(String.join(".", track));
                return;
            }
            for (int i = start + 1; i <= 3 + start&&i<=s.length(); i++) {
                String substring = s.substring(start, i);
                if (substring.length() > 1 && substring.charAt(0) == '0') {
                    break;
                }
                if (Integer.parseInt(substring) > 255) {
                    continue;
                }
                track.addLast(substring);
                backtrack(s, i);
                track.removeLast();
            }
        }

        // private void backtrack(String s, int start) {
        //     if (s.length() == start && track.size() == 4) {
        //         res.add(String.join(".", track));
        //         return;
        //     }
        //     for (int i = start; i < s.length() && i < start + 3; i++) {
        //
        //         if (s.charAt(start) == '0' && i > start) {
        //             return;
        //         }
        //         String substring = s.substring(start, i + 1);
        //         if (Integer.parseInt(substring) > 255) {
        //             continue;
        //         }
        //         track.add(substring);
        //         backtrack(s, i + 1);
        //         track.removeLast();
        //
        //     }
        // }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P93RestoreIpAddresses().new Solution();
        // put your test code here

    }
}
