package leetcode.editor.cn;

public class P134GasStation {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int sum = 0;
            int n = gas.length;
            for (int i = 0; i < n; i++) {
                sum += gas[i] - cost[i];
            }
            if (sum < 0) return -1;
            int tank = 0;
            int start = 0;
            for (int i = 0; i < n; i++) {
                tank += gas[i] - cost[i];
                if (tank < 0) {
                    start = i + 1;
                    tank = 0;
                }
            }
            return start == n ? 0 : start;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P134GasStation().new Solution();
        // put your test code here

    }
}
