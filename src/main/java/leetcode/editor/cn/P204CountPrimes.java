package leetcode.editor.cn;

import java.util.Arrays;

public class P204CountPrimes {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countPrimes(int n) {
            boolean[] isPrime = new boolean[n];
            Arrays.fill(isPrime, true);
            for (int i = 2; i * i < n; i++) {
                if (isPrime[i]) {
                    for (int j = i * i; j < n; j += i) {
                        isPrime[j] = false;
                    }
                }
            }
            int res = 0;
            for (int i = 2; i < n; i++) {
                boolean p = isPrime[i];
                if (p) {
                    res++;
                }
            }
            return res;
        }

    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P204CountPrimes().new Solution();
        // put your test code here

    }
}
