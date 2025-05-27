package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P967NumbersWithSameConsecutiveDifferences {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        LinkedList<Integer> res;
        int digit = 0, count = 0;
        public int[] numsSameConsecDiff(int n, int k) {
            res = new LinkedList<>();
            backtrack(n, k);
            return res.stream().mapToInt(Integer::intValue).toArray();
        }

        private void backtrack(int n, int k) {
            if (count == n) {
                res.add(digit);
                return;
            }
            for (int i = 0; i <= 9; i++) {
                if (count == 0 && i == 0) {
                    continue;
                }
                if (count > 0 && Math.abs(i - (digit % 10)) != k) {
                    continue;
                }
                digit = digit * 10 + i;
                count++;
                backtrack(n, k);
                digit = digit / 10;
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
