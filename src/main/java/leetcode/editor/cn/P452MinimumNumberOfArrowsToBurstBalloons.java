package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.cn.common.*;

public class P452MinimumNumberOfArrowsToBurstBalloons {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMinArrowShots(int[][] points) {
            int count = 1;
            Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
            int xEnd = points[0][1];
            for (int[] point : points) {
                if (point[0] > xEnd) {
                    count++;
                    xEnd = point[1];
                }
            }
            return count;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new P452MinimumNumberOfArrowsToBurstBalloons().new Solution();
        // put your test code here
        
    }
}
