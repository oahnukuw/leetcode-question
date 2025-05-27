package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P187RepeatedDnaSequences {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> findRepeatedDnaSequences(String s) {
            int left = 0, right = 0;
            int windowSequence = 0;
            HashSet<Integer> set = new HashSet<>();
            Set<String> res = new HashSet<>();
            int R = 4, L = 10;
            while (right < s.length()) {
                char c = s.charAt(right++);
                int appendVal = getCharVal(c);

                windowSequence = R * windowSequence + appendVal;

                if (right - left == L) {
                    char d = s.charAt(left);
                    if (set.contains(windowSequence)) {
                        res.add(s.substring(left, right));
                    } else {
                        set.add(windowSequence);
                    }
                    int delVal = getCharVal(d);
                    windowSequence -= (int) (delVal * Math.pow(R, L - 1));
                    left++;
                }
            }
            return new ArrayList<>(res);
        }

        private int getCharVal(char c) {
            int val = 0;
            switch (c) {
                case 'A':
                    val = 0;
                    break;
                case 'C':
                    val = 1;
                    break;
                case 'G':
                    val = 2;
                    break;
                case 'T':
                    val = 3;
                    break;
            }
            return val;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P187RepeatedDnaSequences().new Solution();
        // put your test code here

    }
}
