package leetcode.editor.cn;

import java.util.Arrays;

public class P354RussianDollEnvelopes {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxEnvelopes(int[][] envelopes) {
            int n = envelopes.length;
            Arrays.sort(envelopes, (int[] a, int[] b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
            int piles = 0;
            int[] top = new int[n];
            for (int i = 0; i < n; i++) {
                int left = 0, right = piles;
                int poke = envelopes[i][1];
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    if (top[mid] < poke) {
                        left = mid + 1;
                    } else if (top[mid] >= poke) {
                        right = mid;
                    }
                }
                if (left == piles) {
                    piles++;
                }
                top[left] = poke;
            }
            return piles;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P354RussianDollEnvelopes().new Solution();
        // put your test code here

    }
}
