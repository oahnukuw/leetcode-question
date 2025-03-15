package leetcode.editor.cn;

public class P80RemoveDuplicatesFromSortedArrayIi {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int removeDuplicates(int[] nums) {
            int slow = 0, fast = 0;
            while (fast < nums.length) {
                if (nums[slow] != nums[fast]) {
                    slow++;
                    nums[slow] = nums[fast];
                }else if (fast != slow) {
                    if (slow == 0 && nums[fast] == nums[slow]) {
                        slow++;
                    } else if (slow > 0 && nums[fast] == nums[slow] && nums[slow - 1] != nums[slow]) {
                        slow++;
                        nums[slow] = nums[fast];
                    }
                }
                fast++;
            }
            return slow+1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P80RemoveDuplicatesFromSortedArrayIi().new Solution();
        // put your test code here

    }
}
