package leetcode.editor.cn;

import java.util.*;

public class P1631PathWithMinimumEffort {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumEffortPath(int[][] heights) {
            List<int[]>[] graph = buildGraph(heights);
            int[] distTo = dijkstra(graph, 0);
            return distTo[distTo.length - 1];
        }

        private int[] dijkstra(List<int[]>[] graph, int start) {
            int[] distTo = new int[graph.length];
            Arrays.fill(distTo, Integer.MAX_VALUE);
            distTo[start] = 0;
            PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
            q.offer(new int[]{start, 0});

            while (!q.isEmpty()) {
                int[] curNode = q.poll();
                int curId = curNode[0];
                int curDistFromStart = curNode[1];
                if (curId == graph.length - 1) {
                    return distTo;
                }
                if (curDistFromStart > distTo[curId]) {
                    continue;
                }
                List<int[]> nextEdges = graph[curId];
                for (int[] next : nextEdges) {
                    int nextId = next[0];
                    int nextDist = next[1];
                    int nextDistFromStart = Math.max(nextDist, distTo[curId]);
                    if (nextDistFromStart < distTo[nextId]) {
                        distTo[nextId] = nextDistFromStart;
                        q.offer(new int[]{nextId, nextDistFromStart});
                    }
                }
            }
            return distTo;
        }

        private List<int[]>[] buildGraph(int[][] heights) {
            int m = heights.length, n = heights[0].length;
            // destination is graph[m*n-1]
            List<int[]>[] graph = new List[m * n];
            for (int i = 0; i < graph.length; i++) {
                graph[i] = new ArrayList<>();
            }
            for (int i = 0; i < heights.length; i++) {
                for (int j = 0; j < heights[i].length; j++) {
                    List<int[]> edges = graph[i * n + j];
                    // add left edge
                    if (j - 1 >= 0) {
                        edges.add(new int[]{i * n + j - 1, Math.abs(heights[i][j - 1] - heights[i][j])});
                    }
                    // add right edge
                    if (j + 1 < n) {
                        edges.add(new int[]{i * n + j + 1, Math.abs(heights[i][j + 1] - heights[i][j])});
                    }
                    // add up edge
                    if (i - 1 >= 0) {
                        edges.add(new int[]{(i - 1) * n + j, Math.abs(heights[i - 1][j] - heights[i][j])});
                    }
                    // add down edge
                    if (i + 1 < m) {
                        edges.add(new int[]{(i + 1) * n + j, Math.abs(heights[i + 1][j] - heights[i][j])});
                    }
                }
            }
            return graph;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P1631PathWithMinimumEffort().new Solution();
        // put your test code here

    }
}
