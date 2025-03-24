package leetcode.editor.cn;

public class P1011CapacityToShipPackagesWithinDDays {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int shipWithinDays(int[] weights, int days) {
            int left = 0, right = 1;
            for (int weight : weights) {
                left = Math.max(weight, left);
                right += weight;
            }
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (f(weights, mid) <= days) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }

        private int f(int[] weights, int loadCapacity) {
            int days = 0;
            for (int i = 0; i < weights.length; ) {
                int cap = loadCapacity;
                while (i < weights.length) {
                    if (weights[i] > cap) {
                        break;
                    } else {
                        cap -= weights[i];
                    }
                    i++;
                }
                days++;
            }
            return days;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P1011CapacityToShipPackagesWithinDDays().new Solution();
        // put your test code here

    }
}
