package leetcode.editor.cn;

public class P43MultiplyStrings {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String multiply(String num1, String num2) {
            int m = num1.length(), n = num2.length();
            int[] res = new int[m + n];
            // 左高位，右低位
            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                    int hi = i + j, lo = i + j + 1;
                    int sum = mul + res[lo];
                    res[lo] = sum % 10;
                    res[hi] += sum / 10;
                }
            }
            int i = 0;
            while (i < res.length && res[i] == 0) {
                i++;
            }
            StringBuilder sb = new StringBuilder();
            while (i < res.length) {
                sb.append(res[i++]);
            }
            return sb.length() == 0 ? "0" : sb.toString();
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P43MultiplyStrings().new Solution();
        // put your test code here

    }
}
