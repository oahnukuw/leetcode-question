package leetcode.editor.cn;

public class P1094CarPooling {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int[] diff;

        public boolean carPooling(int[][] trips, int capacity) {
            int m = trips.length;
            int n = 0;
            for (int[] trip : trips) {
                n = Math.max(n, trip[2]);
            }
            diff = new int[n];
            for (int[] trip : trips) {
                increment(trip[1], trip[2]-1, trip[0]);
            }
            for (int i : result()) {
                if (i > capacity) {
                    return false;
                }
            }
            return true;
        }

        private void increment(int l, int r, int val) {
            diff[l] += val;
            if (r + 1 < diff.length) {
                diff[r + 1] -= val;
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
        Solution solution = new P1094CarPooling().new Solution();
        // put your test code here
        int[][] trips = new int[][]{{2, 1, 5}, {3, 5, 7}};
        solution.carPooling(trips, 3);

    }
}
