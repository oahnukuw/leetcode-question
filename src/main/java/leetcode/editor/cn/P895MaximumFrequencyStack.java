package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class P895MaximumFrequencyStack {

    // leetcode submit region begin(Prohibit modification and deletion)
    class FreqStack {
        int maxFreq = 0;
        Map<Integer, Integer> valTofreqs;
        Map<Integer, Stack<Integer>> freqToVals;

        public FreqStack() {
            valTofreqs = new HashMap<>();
            freqToVals = new HashMap<>();
        }

        public void push(int val) {
            int freq = valTofreqs.getOrDefault(val, 0) + 1;
            valTofreqs.put(val, freq);
            freqToVals.putIfAbsent(freq, new Stack<>());
            freqToVals.get(freq).push(val);
            maxFreq = Math.max(freq, maxFreq);
        }

        public int pop() {
            Stack<Integer> maxFreqStack = freqToVals.get(maxFreq);
            Integer maxFreqVal = maxFreqStack.pop();
            valTofreqs.put(maxFreqVal, valTofreqs.get(maxFreqVal) - 1);
            if (maxFreqStack.isEmpty()) {
                maxFreq--;
            }
            return maxFreqVal;
        }
    }

    /**
     * Your FreqStack object will be instantiated and called as such:
     * FreqStack obj = new FreqStack();
     * obj.push(val);
     * int param_2 = obj.pop();
     */
    // leetcode submit region end(Prohibit modification and deletion)
    public static void main(String[] args) {
        // put your test code here

    }
}
