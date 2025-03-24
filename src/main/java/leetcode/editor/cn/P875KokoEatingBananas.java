package leetcode.editor.cn;

public class P875KokoEatingBananas {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minEatingSpeed(int[] piles, int h) {
            int left = 1, right = 1000000000 + 1;

            while (left < right) {
                int mid = left + (right - left) / 2;
                if (f(piles, mid) <= h) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }

        private long f(int[] piles, int k) {
            long hours = 0;
            for (int i = 0; i < piles.length; i++) {
                hours += piles[i] / k;
                if (piles[i] % k > 0) {
                    hours++;
                }
            }
            return hours;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P875KokoEatingBananas().new Solution();
        // put your test code here

        solution.minEatingSpeed(new int[]{312884470}, 312884469);
    }
}
