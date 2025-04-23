package leetcode.editor.cn;

import java.util.*;

public class P433MinimumGeneticMutation {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        HashSet<String> bankSet;
        HashSet<String> visited;

        public int minMutation(String startGene, String endGene, String[] bank) {
            bankSet = new HashSet<>(Arrays.asList(bank));
            if(!bankSet.contains(endGene)) return -1;
            visited = new HashSet<>();
            Queue<String> q = new ArrayDeque<>();
            q.offer(startGene);
            visited.add(startGene);
            int step = 0;
            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    String cur = q.poll();
                    if (endGene.equals(cur)) {
                        return step;
                    }
                    List<String> neighbors = getNeighbors(cur);
                    for (String neighbor : neighbors) {
                        if (!visited.contains(neighbor)) {
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
            char[] ch = cur.toCharArray();
            List<String> neighbors = new ArrayList<>();
            for (int i = 0; i < ch.length; i++) {
                char[] candidates = new char[]{'A', 'C', 'G', 'T'};
                char[] neighbor = Arrays.copyOf(ch, ch.length);
                for (Character candidate : candidates) {
                    neighbor[i] = candidate;
                    String newNeighbor = new String(neighbor);
                    if (bankSet.contains(newNeighbor)) {
                        neighbors.add(newNeighbor);
                    }
                }
            }
            return neighbors;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P433MinimumGeneticMutation().new Solution();
        // put your test code here

    }
}
