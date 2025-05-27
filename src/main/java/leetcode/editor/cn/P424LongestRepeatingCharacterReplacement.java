package leetcode.editor.cn;

public class P424LongestRepeatingCharacterReplacement {


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int characterReplacement(String s, int k) {
            int[] charCount = new int[26];
            int left = 0, right = 0;
            int windowMaxCount = 0;
            int res = 0;
            while (right < s.length()) {
                char c = s.charAt(right);
                int index = c - 'A';
                charCount[index]++;
                windowMaxCount = Math.max(charCount[index], windowMaxCount);
                right++;

                if (right - left - windowMaxCount > k) {
                    char d = s.charAt(left);
                    int dIndex = d - 'A';
                    charCount[dIndex]--;
                    left++;
                }
                res = Math.max(res, right - left);
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
