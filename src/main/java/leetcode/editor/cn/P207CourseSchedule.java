package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P207CourseSchedule {
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        boolean[] onPath;
        boolean[] visited;
        boolean hasCycle = false;

        public boolean canFinish(int numCourses, int[][] prerequisites) {
            return traverseBFS(numCourses, prerequisites);
        }

        private boolean traverseBFS(int numCourses, int[][] prerequisites) {
            List<Integer>[] graph = buildGraph(numCourses, prerequisites);
            int[] indegree = new int[numCourses];
            for (int[] edge : prerequisites) {
                int from = edge[1], to = edge[0];
                indegree[to]++;
            }

            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < numCourses; i++) {
                if (indegree[i] == 0) {
                    q.offer(i);
                }
            }
            int count = 0;
            while (!q.isEmpty()) {
                int size = q.size();
                Integer cur = q.poll();
                List<Integer> edges = graph[cur];
                count++;
                for (Integer next : edges) {
                    indegree[next]--;
                    if (indegree[next] == 0) {
                        q.offer(next);
                    }
                }
            }
            return count == numCourses;

        }
        // public boolean canFinish(int numCourses, int[][] prerequisites) {
        //     List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        //     onPath = new boolean[numCourses];
        //     visited = new boolean[numCourses];
        //     for (int i = 0; i < numCourses; i++) {
        //         traverseDFS(graph, i);
        //     }
        //     return !hasCycle;
        // }

        private void traverseDFS(List<Integer>[] graph, int src) {
            if (onPath[src]) {
                hasCycle = true;
                return;
            }
            if (hasCycle || visited[src]) return;

            visited[src] = true;
            onPath[src] = true;
            List<Integer> edges = graph[src];
            for (Integer edge : edges) {
                traverseDFS(graph, edge);
            }
            onPath[src] = false;
        }

        private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
            List<Integer>[] graph = new List[numCourses];
            // Verify whether the edges of graph can have list
            for (int i = 0; i < graph.length; i++) {
                graph[i] = new LinkedList<>();
            }

            // for (List<Integer> edges : graph) {
            //     edges = new LinkedList<>();
            // }
            for (int[] edge : prerequisites) {
                int from = edge[1], to = edge[0];
                graph[from].add(to);
            }
            return graph;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P207CourseSchedule().new Solution();
        // put your test code here

    }
}
