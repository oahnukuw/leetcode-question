package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.cn.common.*;

public class P473MatchsticksToSquare {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        boolean found = false;
        public boolean makesquare(int[] matchsticks) {
            int sum = 0;
            for (int matchstick : matchsticks) sum += matchstick;
            if (sum % 4 != 0) return false;
            int target = sum / 4;
            Arrays.sort(matchsticks);
            int[] bucket = new int[4];
            backtrack(matchsticks, target, bucket, matchsticks.length - 1);
            return found;
        }

        private void backtrack(int[] matchsticks, int target, int[] bucket, int index) {
            if(found) return;
            if (index < 0) {
                found = true;
                return;
            }

            for (int i = 0; i < bucket.length; i++) {
                if (bucket[i] + matchsticks[index] > target) {
                    continue;
                }
                if (i > 0 && bucket[i] == bucket[i - 1]) {
                    continue;
                }

                bucket[i] += matchsticks[index];
                backtrack(matchsticks, target, bucket, index - 1);
                bucket[i] -= matchsticks[index];
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new P473MatchsticksToSquare().new Solution();
        // put your test code here
        
    }
}
