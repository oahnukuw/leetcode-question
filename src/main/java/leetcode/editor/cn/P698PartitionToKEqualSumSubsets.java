package leetcode.editor.cn;

import java.util.Arrays;

public class P698PartitionToKEqualSumSubsets {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        boolean found = false;

        public boolean canPartitionKSubsets(int[] nums, int k) {
            int sum = 0;
            for (int num : nums) sum += num;
            if (sum % k != 0) return false;

            int target = sum / k;
            int[] bucket = new int[k];
            Arrays.sort(nums);
            backtrack(nums, bucket, nums.length-1, target);
            return found;
        }

        private void backtrack(int[] nums, int[] bucket, int index, int target) {
            if (found) return;
            if (index < 0) {
                found = true;
                return;
            }

            for (int i = 0; i < bucket.length; i++) {
                if (nums[index] + bucket[i] > target) {
                    continue;
                }
                if (i > 0 && bucket[i] == bucket[i - 1]) {
                    continue;
                }
                bucket[i] += nums[index];
                backtrack(nums, bucket, index - 1, target);
                bucket[i] -= nums[index];
            }
        }

        // public boolean canPartitionKSubsets(int[] nums, int k) {
        //     int sum = 0;
        //     for (int num : nums) sum += num;
        //     if (sum % k != 0) return false;
        //
        //     int target = sum / k;
        //     boolean[] used = new boolean[nums.length];
        //     int bucketSum = 0;
        //     backtrack(k, nums, bucketSum, used, target, 0);
        //     return found;
        // }

        // 对于每一个桶，都可以在n个数字中选择能装满的数，这些数在 nums[] 中是任意的自序列。所以对于每个桶而言，都应该从0开始枚举，这便需要用到used[i]来竖向记录被其他桶用过的数。对于桶内的选择，选择范围是从 start 开始的。往下深入的穷举时，保证了每个数字都被该桶选过。
        // private void backtrack(int k, int[] nums, int bucketSum, boolean[] used, int target, int start) {
        //     if (found) {
        //         return;
        //     }
        //
        //     if (k == 0) {
        //         found = true;
        //         return;
        //     }
        //
        //     if (target == bucketSum) {
        //         backtrack(k - 1, nums, 0, used, target, 0);
        //     }
        //
        //     for (int i = start; i < nums.length; i++) {
        //         if (used[i]) {
        //             continue;
        //         }
        //         if (nums[i] + bucketSum > target) {
        //             continue;
        //         }
        //         used[i] = true;
        //         bucketSum += nums[i];
        //         backtrack(k, nums, bucketSum, used, target, i + 1);
        //         used[i] = false;
        //         bucketSum -= nums[i];
        //
        //     }
        //
        // }

    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P698PartitionToKEqualSumSubsets().new Solution();
        // put your test code here

    }
}
