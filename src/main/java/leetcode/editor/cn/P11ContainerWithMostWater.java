package leetcode.editor.cn;

public class P11ContainerWithMostWater {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxArea(int[] height) {
            int res = 0;
            int n = height.length;
            int left = 0, right = n - 1;
            while (left < right) {

                if (height[left] < height[right]) {
                    res = Math.max(res, (right - left) * height[left]);
                    left++;
                } else {
                    res = Math.max(res, (right - left) * height[right]);
                    right--;
                }
            }
            return res;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P11ContainerWithMostWater().new Solution();
        // put your test code here

    }
}
