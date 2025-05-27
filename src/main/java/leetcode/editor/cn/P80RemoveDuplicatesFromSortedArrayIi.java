package leetcode.editor.cn;

public class P80RemoveDuplicatesFromSortedArrayIi {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int removeDuplicates(int[] nums) {
            int slow = 1, fast = 2;
            // Define: [0...slow] Element show at most twice
            while (fast < nums.length) {
                if (slow >= 1 && nums[fast] != nums[slow - 1]) {
                    slow++;
                    nums[slow] = nums[fast];
                }
                fast++;
            }
            return slow + 1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P80RemoveDuplicatesFromSortedArrayIi().new Solution();
        // put your test code here

    }
}
