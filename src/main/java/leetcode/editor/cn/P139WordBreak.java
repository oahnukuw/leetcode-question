package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class P139WordBreak {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] recurMemo;

        boolean found = false;
        HashSet<String> btMemo = new HashSet<>();
        StringBuilder subString = new StringBuilder();
        List<String> wordDict;

        public boolean wordBreak(String s, List<String> wordDict) {
            // recur -----------------
            recurMemo = new int[s.length() + 1];
            Arrays.fill(recurMemo, -1);
            return recur(s, wordDict);
            // recur -----------------
            // backtrack ------------------------------
            // this.wordDict = wordDict;
            // backtrack(s, 0);
            // return found;
            // backtrack ------------------------------
        }

        private void backtrack(String s, int i) {
            int sLen = s.length();
            if (found) {
                return;
            }
            if (i == sLen) {
                found = true;
                return;
            }
            String sb = s.substring(i);
            if (btMemo.contains(sb)) {
                return;
            }
            for (String word : wordDict) {
                int suffixLen = i + word.length();
                if (suffixLen <= sLen && s.substring(i, suffixLen).equals(word)) {
                    subString.append(word);
                    backtrack(s, suffixLen);
                    subString.delete(subString.length() - word.length(), subString.length());
                }
            }
            if (!found) {
                btMemo.add(sb);
            }
        }

        private boolean recur(String s, List<String> wordDict) {
            // base case
            if (s.isEmpty()) return true;
            int sLen = s.length();
            if (recurMemo[sLen] != -1) {
                // 1:true; 0:false
                return recurMemo[sLen] != 0;
            }
            for (String word : wordDict) {
                int wordLen = word.length();
                if (sLen >= wordLen && word.equals(s.substring(sLen - wordLen))) {
                    boolean subTrue = recur(s.substring(0, sLen - wordLen), wordDict);
                    if (subTrue) {
                        recurMemo[sLen] = 1;
                        return true;
                    }
                }
            }
            recurMemo[sLen] = 0;
            return false;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P139WordBreak().new Solution();
        // put your test code here
    }
}
