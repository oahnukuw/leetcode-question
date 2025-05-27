package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Random;

public class P384ShuffleAnArray {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] initNums;
        Random random = new Random();

        public Solution(int[] nums) {
            this.initNums = nums;
        }

        public int[] reset() {
            return initNums;
        }

        public int[] shuffle() {
            int n = initNums.length;
            int[] randomNums = Arrays.copyOf(initNums, n);
            for (int i = 0; i < n; i++) {
                int r = i + random.nextInt(n - i);
                int temp = randomNums[i];
                randomNums[i] = randomNums[r];
                randomNums[r] = temp;
            }
            return randomNums;
        }
    }

    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(nums);
     * int[] param_1 = obj.reset();
     * int[] param_2 = obj.shuffle();
     */
    // leetcode submit region end(Prohibit modification and deletion)
    public static void main(String[] args) {
        // put your test code here

    }
}
