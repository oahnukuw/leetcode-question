package leetcode.editor.cn;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class P460LfuCache {

    // leetcode submit region begin(Prohibit modification and deletion)
    class LFUCache {
        private HashMap<Integer, Integer> keyToVal;
        private HashMap<Integer, Integer> keyToFreq;
        private HashMap<Integer, LinkedHashSet<Integer>> freqToKeys;
        private int capacity;
        private int minFreq;

        public LFUCache(int capacity) {
            keyToVal = new HashMap<>(capacity);
            keyToFreq = new HashMap<>(capacity);
            freqToKeys = new HashMap<>(capacity);
            this.capacity = capacity;
            this.minFreq = 0;
        }

        public int get(int key) {
            if (!keyToVal.containsKey(key)) {
                return -1;
            }
            increaseFreq(key);
            return keyToVal.get(key);
        }

        private void increaseFreq(int key) {
            // 1. keyToFreq + 1
            Integer curFreq = keyToFreq.get(key);
            int newFreq = curFreq + 1;
            keyToFreq.put(key, newFreq);
            // 2. freqToKeys remove key and add (key,key.freq+1)
            LinkedHashSet<Integer> keySet = freqToKeys.get(curFreq);
            keySet.remove(key);
            freqToKeys.putIfAbsent(newFreq, new LinkedHashSet<>());
            freqToKeys.get(newFreq).add(key);
            // 3. Update the minFreq
            if (keySet.isEmpty()) {
                freqToKeys.remove(curFreq);
                if (curFreq == minFreq) {
                    minFreq = newFreq;
                }
            }
        }

        public void put(int key, int value) {
            if (keyToVal.containsKey(key)) {
                keyToVal.put(key, value);
                increaseFreq(key);
                return;
            }

            if (keyToVal.size() == this.capacity) {
                removeLFUKey();
            }
            keyToVal.put(key, value);
            final int freq = 1;
            minFreq = freq;
            keyToFreq.put(key, freq);
            freqToKeys.putIfAbsent(freq, new LinkedHashSet<>());
            freqToKeys.get(freq).add(key);
            // System.out.println("" + key + " " + keyToVal.get(key));
        }

        private void removeLFUKey() {
            LinkedHashSet<Integer> minFreqSet = freqToKeys.get(minFreq);
            Integer keyToRemove = minFreqSet.iterator().next();
            minFreqSet.remove(keyToRemove);
            if (minFreqSet.isEmpty()) {
                freqToKeys.remove(minFreq);
            }
            keyToVal.remove(keyToRemove);
            keyToFreq.remove(keyToRemove);
        }
    }

    /**
     * Your LFUCache object will be instantiated and called as such:
     * LFUCache obj = new LFUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
    // leetcode submit region end(Prohibit modification and deletion)
    public static void main(String[] args) {
        // put your test code here

    }
}
