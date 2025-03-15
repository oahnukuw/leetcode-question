package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.cn.common.*;

public class P344ReverseString {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void reverseString(char[] s) {
            int l = 0, r = s.length - 1;
            while (l < r) {
                char temp = s[l];
                s[l] = s[r];
                s[r] = temp;
                l++;
                r--;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new P344ReverseString().new Solution();
        // put your test code here
        
    }
}
