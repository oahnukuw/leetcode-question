package leetcode.editor.cn;

import java.util.Arrays;

public class P300LongestIncreasingSubsequence {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] memo;

        public int lengthOfLIS(int[] nums) {
            // Iteration from bottom to top --------------
            // int n = nums.length;
            // memo = new int[n];
            // Arrays.fill(memo, 1);
            // for (int i = 1; i < nums.length; i++) {
            //     for (int j = 0; j < i; j++) {
            //         if (nums[i] > nums[j]) {
            //             memo[i] = Math.max(memo[j] + 1, memo[i]);
            //         }
            //     }
            // }
            // int res = 1;
            // for (int e : memo) {
            //     res = Math.max(e, res);
            // }
            // return res;
            // Iteration from bottom to top --------------

            // divide search and build piles ----------------------------
            // int[] top = new int[nums.length];
            // int piles = 0;
            // for (int i = 0; i < nums.length; i++) {
            //     int poke = nums[i];
            //     int left = 0, right = piles;
            //     while (left < right) {
            //         int mid = left + (right - left) / 2;
            //         if (top[mid] < poke) {
            //             left = mid + 1;
            //         } else if (top[mid] >= poke) {
            //             right = mid;
            //         }
            //     }
            //     if (left == piles) {
            //         piles++;
            //     }
            //     top[left] = poke;
            // }
            // return piles;
            // divide search and build piles ----------------------------
            // recur ----------------------------
            int n = nums.length;
            memo = new int[n];
            Arrays.fill(memo, -1);
            for (int i = 0; i < n; i++) {
                memo[i] = recur(nums, i);
            }
            int res = 0;
            for (int e : memo) {
                res = Math.max(res, e);
            }
            return res;
            // recur ----------------------------
        }

        int recur(int[] nums, int i) {
            if (i == 0) return 1;
            if (memo[i] != -1) return memo[i];
            int lisI = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    lisI = Math.max(lisI, recur(nums, j) + 1);
                }
            }
            memo[i] = lisI;
            return lisI;
        }

    }

    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P300LongestIncreasingSubsequence().new Solution();
        int[] ints = {10, 9, 2, 5, 3, 7, 101, 18};
        solution.lengthOfLIS(ints);
        // put your test code here

    }
}
