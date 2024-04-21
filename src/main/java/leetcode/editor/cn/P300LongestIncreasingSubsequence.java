//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。 
//
// 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子
//序列。 
//
// 示例 1： 
//
// 
//输入：nums = [10,9,2,5,3,7,101,18]
//输出：4
//解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,0,3,2,3]
//输出：4
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,7,7,7,7,7,7]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2500 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
//
// 进阶： 
//
// 
// 你能将算法的时间复杂度降低到 O(n log(n)) 吗? 
// 
//
// Related Topics数组 | 二分查找 | 动态规划 
//
// 👍 3411, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

import java.util.Arrays;

//Java：最长递增子序列
public class P300LongestIncreasingSubsequence{
    public static void main(String[] args) {
        Solution solution = new P300LongestIncreasingSubsequence().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int lis = 1;
    int[] memo;
    public int lengthOfLIS(int[] nums) {
        // recursion
//        memo = new int[nums.length+1];
//        Arrays.fill(memo, -1);
//        dp(nums, nums.length-1);
//        return lis;
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp, 1);
        for(int i=1; i<nums.length; i++){
            for(int j=0; j<i; j++){
                if(nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        int lis = 1;
        for(int i=0; i<nums.length; i++){
            if(lis<dp[i]){
                lis=dp[i];
            }
        }
        return lis;
    }
    int dp(int[] nums, int i){
        if (memo[i] != -1) {
            return memo[i];
        }
        int res = -1;
        for(int j=0; j<i; j++){
            int sub = dp(nums, j);
            if(nums[i]>nums[j]){
                res = Math.max(res, sub+1);
                lis = Math.max(res,lis);
            }
        }
        if(res==-1){
            memo[i]=1;
        }else {
            memo[i] = res;
        }
        return memo[i];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
