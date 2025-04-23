package leetcode.editor.cn;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P841KeysAndRooms {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        HashSet<Integer> visited = new HashSet<>();

        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            bfs(rooms);
            // dfs(rooms, 0);
            return visited.size() == rooms.size();
        }

        private void bfs(List<List<Integer>> rooms) {
            visited.add(0);
            Queue<Integer> q = new LinkedList<>();
            q.offer(0);
            while (!q.isEmpty()) {
                Integer cur = q.poll();
                List<Integer> neighbors = rooms.get(cur);
                for (Integer neighbor : neighbors) {
                    if (!visited.contains(neighbor)) {
                        q.offer(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
        }

        void dfs(List<List<Integer>> rooms, int src) {
            if (visited.contains(src)) {
                return;
            }
            visited.add(src);
            for (Integer neighbor : rooms.get(src)) {
                dfs(rooms, neighbor);
            }
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P841KeysAndRooms().new Solution();
        // put your test code here

    }
}
