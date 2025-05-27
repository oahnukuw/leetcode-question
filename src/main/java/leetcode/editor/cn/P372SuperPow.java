package leetcode.editor.cn;

public class P372SuperPow {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int base = 1337;

        public int superPow(int a, int[] b) {
            return getPower(a, b, b.length - 1);
        }

        int getPower(int a, int[] b, int last) {
            if (last == -1) {
                return 1;
            }
            int s = b[last--];
            int res = pow(a, s) * pow(getPower(a, b, last), 10);
            return res % 1337;
        }

        // calculate a^s and % 1337
        // (ab)%k = (a%k)*(b%k)%k
        private int pow(int a, int s) {
            // a = a % base;
            // int res = 1;
            // for (int i = 0; i < s; i++) {
            //     res *= a;
            //     res %= base;
            // }
            // return res;
            // power formula-------------------
            if (s == 0) {
                return 1;
            }
            a %= base;
            if (s % 2 == 1) {
                return a * pow(a, s - 1) % base;
            } else {
                int sub = pow(a, s / 2);
                return sub * sub % base;
            }
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P372SuperPow().new Solution();
        // put your test code here

    }
}
