//给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。 
//
// 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。 
//
// 请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。 
//
// 注意：不允许旋转信封。 
//
// 示例 1： 
//
// 
//输入：envelopes = [[5,4],[6,4],[6,7],[2,3]]
//输出：3
//解释：最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。 
//
// 示例 2： 
//
// 
//输入：envelopes = [[1,1],[1,1],[1,1]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= envelopes.length <= 10⁵ 
// envelopes[i].length == 2 
// 1 <= wi, hi <= 10⁵ 
// 
//
// Related Topics数组 | 二分查找 | 动态规划 | 排序 
//
// 👍 958, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

import java.util.Arrays;

//Java：俄罗斯套娃信封问题
public class P354RussianDollEnvelopes{
    public static void main(String[] args) {
        Solution solution = new P354RussianDollEnvelopes().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (int[] a, int[] b)
                -> a[0]==b[0]? b[1]-a[1]:a[0]-b[0]);
        int[] height = new int[envelopes.length];
        for(int i=0; i<envelopes.length; i++){
            height[i] = envelopes[i][1];
        }
        return longestLIS(height);

    }

        private int longestLIS(int[] nums) {
            int[] top = new int[nums.length];
            // 牌堆数初始化为 0
            int piles = 0;
            for (int i = 0; i < nums.length; i++) {
                // 要处理的扑克牌
                int poker = nums[i];

                /***** 搜索左侧边界的二分查找 *****/
                int left = 0, right = piles;
                while (left < right) {
                    int mid = (left + right) / 2;
                    if (top[mid] > poker) {
                        right = mid;
                    } else if (top[mid] < poker) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                /*********************************/

                // 没找到合适的牌堆，新建一堆
                if (left == piles) piles++;
                // 把这张牌放到牌堆顶
                top[left] = poker;
            }
            // 牌堆数就是 LIS 长度
            return piles;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
