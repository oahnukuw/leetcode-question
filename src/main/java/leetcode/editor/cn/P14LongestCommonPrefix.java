package leetcode.editor.cn;

public class P14LongestCommonPrefix {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            int m = strs.length;
            int n = strs[0].length();
            for (int col = 0; col < n; col++) {
                for (int row = 1; row < m; row++) {
                    String thisStr = strs[row], prevStr = strs[row - 1];
                    if (col >= thisStr.length() || col >= prevStr.length() || thisStr.charAt(col) != prevStr.charAt(col)) {
                        return thisStr.substring(0, col);
                    }
                }
            }
            return strs[0];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new P14LongestCommonPrefix().new Solution();
        // put your test code here
        
    }
}
