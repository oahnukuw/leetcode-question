package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class P967NumbersWithSameConsecutiveDifferences {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<Integer> res = new ArrayList<>();
        int track = 0;
        int count = 0;

        public int[] numsSameConsecDiff(int n, int k) {
            backtrack(n, k);
            int size = res.size();
            int[] result = new int[size];
            for (int i = 0; i < size; i++) {
                result[i] = res.get(i);
            }
            return result;
        }

        private void backtrack(int n, int k) {
            if (count == n) {
                res.add(track);
                return;
            }

            for (int i = 0; i <= 9; i++) {
                if (count == 0 && i == 0) {
                    continue;
                }
                int last = track % 10;
                if (count > 0 && Math.abs(last - i) != k) {
                    continue;
                }
                count++;
                track = track * 10 + i;
                backtrack(n, k);
                track /= 10;
                count--;
            }
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P967NumbersWithSameConsecutiveDifferences().new Solution();
        solution.numsSameConsecDiff(3, 7);
        // put your test code here

    }
}
