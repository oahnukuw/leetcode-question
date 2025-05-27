package leetcode.editor.cn;

public class P264UglyNumberIi {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int nthUglyNumber(int n) {
            // init LinkedList head pointer
            int p2 = 1, p3 = 1, p5 = 1;
            // First pointer value
            int product2 = 1, product3 = 1, product5 = 1;
            // ugly number starts from 1 in array
            int[] ugly = new int[n + 1];
            // pointer of result List
            int p = 1;
            while (p <= n) {
                int min = Math.min(product2, Math.min(product3, product5));
                ugly[p++] = min;
                // Calculate the next value of the Lists if the pointer of list has been merged in the result
                // Every number in ugly should be multiplied by 2,3,5 to generate new ugly number.
                if (min == product2) {
                    // product2 has been use then Index p2 of res has not been multiplied by 2 before, so defer the new ugly number by ugly[p2]
                    product2 = 2 * ugly[p2];
                    p2++;
                }
                if (min == product3) {
                    product3 = 3 * ugly[p3];
                    p3++;
                }
                if (min == product5) {
                    product5 = 5 * ugly[p5];
                    p5++;
                }
            }
            return ugly[n];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new P264UglyNumberIi().new Solution();
        // put your test code here
        
    }
}
