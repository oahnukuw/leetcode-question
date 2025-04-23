package leetcode.editor.cn;

import java.util.*;

public class P773SlidingPuzzle {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int slidingPuzzle(int[][] board) {
            String target = "123450";
            StringBuilder sb = new StringBuilder();
            for (int[] row : board) {
                for (int col : row) {
                    sb.append(col);
                }
            }
            String start = sb.toString();

            Queue<String> q = new LinkedList<>();
            HashSet<String> visited = new HashSet<>();
            q.offer(start);
            visited.add(start);
            int step = 0;
            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    String cur = q.poll();
                    if (target.equals(cur)) {
                        return step;
                    }
                    for (String neighbor : getNeighbors(cur)) {
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
            int[][] mapping = new int[][]{
                    {1, 3},
                    {0, 2, 4},
                    {1, 5},
                    {0, 4},
                    {1, 3, 5},
                    {2, 4}
            };
            int index = cur.indexOf('0');
            ArrayList<String> neighbors = new ArrayList<>();
            for (int adj : mapping[index]) {
                String neighbor = swap(cur.toCharArray(), adj, index);
                neighbors.add(neighbor);
            }
            return neighbors;
        }

        private String swap(char[] charArray, int i, int j) {
            char temp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = temp;
            return String.valueOf(charArray);
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P773SlidingPuzzle().new Solution();
        // put your test code here

    }
}
