package leetcode.editor.cn;

public class P42TrappingRainWater {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap(int[] height) {
            int res = 0;
            int n = height.length;
            //---------memo-------------
            // int[] lMax = new int[n], rMax = new int[n];
            // lMax[0] = height[0];
            // rMax[n - 1] = height[n - 1];
            // for (int i = 1; i < n; i++) {
            //     lMax[i] = Math.max(height[i], lMax[i - 1]);
            // }
            // for (int i = n - 2; i >= 0; i--) {
            //     rMax[i] = Math.max(height[i], rMax[i + 1]);
            // }
            // for (int i = 0; i < n; i++) {
            //     res += Math.min(lMax[i], rMax[i]) - height[i];
            // }
            //---------memo-------------

            // -------------double pointer---------------
            int left = 0, right = n - 1;
            int lMax = 0, rMax = 0;
            while (left < right) {
                lMax = Math.max(height[left], lMax);
                rMax = Math.max(height[right], rMax);

                if (lMax < rMax) {
                    res += lMax - height[left];
                    left++;
                } else {
                    res += rMax - height[right];
                    right--;
                }
            }
            // -------------double pointer---------------

            return res;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P42TrappingRainWater().new Solution();
        // put your test code here

    }
}
