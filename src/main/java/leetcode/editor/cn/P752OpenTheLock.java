package leetcode.editor.cn;

import java.util.*;

public class P752OpenTheLock {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        HashSet<String> deads;
        HashSet<String> visited;

        public int openLock(String[] deadends, String target) {
            deads = new HashSet<>(Arrays.asList(deadends));
            if (deads.contains("0000")) return -1;
            visited = new HashSet<>();
            Queue<String> q = new LinkedList<>();
            q.offer("0000");
            visited.add("0000");
            int step = 0;
            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    String cur = q.poll();
                    if (target.equals(cur)) {
                        return step;
                    }
                    for (String neighbor : getNeighbors(cur)) {
                        if (!visited.contains(neighbor) && !deads.contains(neighbor)) {
                            q.offer(neighbor);
                            visited.add(neighbor);
                        }
                    }
                }
                step++;
            }
            return -1;
        }

        private List<String> getNeighbors(String cur) {
            ArrayList<String> neighbors = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                neighbors.add(plusOne(cur.toCharArray(), i));
                neighbors.add(minusOne(cur.toCharArray(), i));
            }
            return neighbors;
        }

        String plusOne(char[] nums, int i) {
            if (nums[i] == '9') {
                nums[i] = '0';
            } else {
                nums[i]++;
            }
            return new String(nums);
        }

        String minusOne(char[] nums, int i) {
            if (nums[i] == '0') {
                nums[i] = '9';
            } else {
                nums[i]--;
            }
            return new String(nums);
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P752OpenTheLock().new Solution();
        // put your test code here

    }
}
