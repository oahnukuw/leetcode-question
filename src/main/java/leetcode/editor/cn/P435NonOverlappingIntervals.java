package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

public class P435NonOverlappingIntervals {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
            int count = 0;
            int xEnd = intervals[0][1];
            for (int[] interval : intervals) {
                if (interval[0] >= xEnd) {
                    xEnd = interval[1];
                } else {
                    count++;
                }
            }
            return count - 1;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P435NonOverlappingIntervals().new Solution();
        // put your test code here

    }
}
