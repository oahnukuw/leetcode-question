package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

public class P853CarFleet {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int carFleet(int target, int[] position, int[] speed) {
            int n = position.length;
            int[][] cars = new int[n][2];
            for (int i = 0; i < n; i++) {
                cars[i][0] = position[i];
                cars[i][1] = speed[i];
            }
            Arrays.sort(cars, Comparator.comparingInt(a -> a[0]));
            double[] time = new double[n];
            for (int i = 0; i < n; i++) {
                time[i] = (double) (target - cars[i][0]) / cars[i][1];
            }
            // Monotonic Stack
            // Stack<Double> stack = new Stack<>();
            // for (int i = 0; i < n; i++) {
            //     while (!stack.isEmpty() && stack.peek() <= time[i]) {
            //         stack.pop();
            //     }
            //     stack.push(time[i]);
            // }
            // return stack.size();

            double maxTime = 0;
            int res = 0;
            for (int i = n - 1; i >= 0; i--) {
                if (time[i] > maxTime) {
                    maxTime = time[i];
                    res++;
                }
            }
            return res;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        // put your test code here

    }
}
