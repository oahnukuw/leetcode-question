package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.cn.common.*;

public class P424LongestRepeatingCharacterReplacement {


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int characterReplacement(String s, int k) {
            // Maintain a window [l,r) that holds the longest same Characters, for example use windowMaxCount to store the value. Then the target is find a longest (r-l-windowMaxCount=k)
            int[] chars = new int[26];
            int windowMaxCount = 0;
            int l = 0, r = 0;
            int res = 0;
            while (r < s.length()) {
                char c = s.charAt(r);
                int indexR = c - 'A';
                chars[indexR]++;
                windowMaxCount = Math.max(windowMaxCount, chars[indexR]);
                r++;
                if (r - l - windowMaxCount > k) {
                    char d = s.charAt(l);
                    int indexL = d - 'A';
                    chars[indexL]--;
                    l++;
                }
                res = Math.max(res, r - l);
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new P424LongestRepeatingCharacterReplacement().new Solution();
        // put your test code here
        
    }
}
