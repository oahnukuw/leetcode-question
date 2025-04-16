package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class P210CourseScheduleIi {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        boolean[] visited;
        boolean[] onPath;
        ArrayList<Integer> postOrder;
        boolean hasCycle = false;

        public int[] findOrder(int numCourses, int[][] prerequisites) {
            visited = new boolean[numCourses];
            onPath = new boolean[numCourses];
            postOrder = new ArrayList<>();
            List<Integer>[] graph = buildGraph(prerequisites, numCourses);
            for (int i = 0; i < graph.length; i++) {
                traverse(graph, i);
                if (hasCycle) return new int[]{};
            }
            int[] res = new int[numCourses];
            int size = postOrder.size();
            for (int i = 0; i < size; i++) {
                res[i] = postOrder.get(size - 1 - i);
            }
            return res;
        }

        private void traverse(List<Integer>[] graph, int src) {
            if (onPath[src]) {
                hasCycle = true;
                return;
            }
            if (hasCycle || visited[src]) {
                return;
            }
            onPath[src] = true;
            visited[src] = true;
            List<Integer> edges = graph[src];
            for (Integer to : edges) {
                traverse(graph, to);
            }
            onPath[src] = false;
            postOrder.add(src);
        }

        private List<Integer>[] buildGraph(int[][] prerequisites, int numCourses) {
            List<Integer>[] graph = new List[numCourses];
            for (int i = 0; i < numCourses; i++) {
                graph[i] = new ArrayList<>();
            }
            for (int[] edge : prerequisites) {
                int from = edge[1], to = edge[0];
                graph[from].add(to);
            }
            return graph;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P210CourseScheduleIi().new Solution();
        // put your test code here

    }
}
