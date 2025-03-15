package leetcode.editor.cn;

public class P977SquaresOfASortedArray {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortedSquares(int[] nums) {
            int p1 = 0, p2 = nums.length - 1;
            int[] res = new int[nums.length];
            int i = nums.length - 1;
            while (p1 <= p2) {
                if (nums[p2] > Math.abs(nums[p1])) {
                    res[i] = nums[p2] * nums[p2];
                    p2--;
                } else {
                    res[i] = nums[p1] * nums[p1];
                    p1++;
                }
                i--;
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new P977SquaresOfASortedArray().new Solution();
        // put your test code here
        
    }
}
