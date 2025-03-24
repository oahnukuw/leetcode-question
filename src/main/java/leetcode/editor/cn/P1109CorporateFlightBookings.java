package leetcode.editor.cn;

public class P1109CorporateFlightBookings {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int[] diff;

        public int[] corpFlightBookings(int[][] bookings, int n) {
            diff = new int[n];
            int m = bookings.length;
            for (int[] booking : bookings) {
                increment(booking[0] - 1, booking[1] - 1, booking[2]);
            }
            return result();

        }

        private void increment(int i, int j, int val) {
            diff[i] += val;
            if (j + 1 < diff.length) {
                diff[j + 1] -= val;
            }
        }

        private int[] result() {
            int[] res = new int[diff.length];
            res[0] = diff[0];
            for (int i = 1; i < diff.length; i++) {
                res[i] = diff[i] + res[i - 1];
            }
            return res;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P1109CorporateFlightBookings().new Solution();
        // put your test code here

    }
}
