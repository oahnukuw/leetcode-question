package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P140WordBreakIi {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String>[] sToRes;
        String inputS;

        public List<String> wordBreak(String s, List<String> wordDict) {
            sToRes = new List[s.length() + 1];
            recur(s, wordDict);
            List<String> res = sToRes[s.length()];
            return res == null ? new ArrayList<>() : res;
        }

        private List<String> recur(String s, List<String> wordDict) {
            if (s.isEmpty()) return Arrays.asList("");
            int sLen = s.length();
            if (sToRes[sLen] != null) {
                return sToRes[sLen];
            }
            for (String word : wordDict) {
                int wordLen = word.length();
                if (sLen >= wordLen && s.substring(sLen - wordLen).equals(word)) {
                    List<String> subList = recur(s.substring(0, sLen - wordLen), wordDict);
                    if (subList != null) {
                        if (sToRes[sLen] == null) {
                            sToRes[sLen] = new ArrayList<>();
                        }
                        List<String> sentences = sToRes[sLen];
                        for (String subString : subList) {
                            sentences.add(subString.isEmpty() ? word : subString + " " + word);
                        }
                    }
                }
            }
            return sToRes[sLen];
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P140WordBreakIi().new Solution();
        // put your test code here

    }
}
