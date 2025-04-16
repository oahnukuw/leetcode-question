package leetcode.editor.cn;

import java.util.*;

public class P743NetworkDelayTime {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int networkDelayTime(int[][] times, int n, int k) {
            List<int[]>[] graph = buildGraph(times, n);
            int[] distTo = dijkstra(graph, k);
            int res = 0;
            for (int i = 1; i < distTo.length; i++) {
                if (distTo[i] == Integer.MAX_VALUE) {
                    return -1;
                }
                res = Math.max(distTo[i], res);
            }
            return res;
        }

        private int[] dijkstra(List<int[]>[] graph, int k) {
            // Shortest distance from start to i
            int[] distTo = new int[graph.length];
            Arrays.fill(distTo, Integer.MAX_VALUE);
            distTo[k] = 0;
            PriorityQueue<State> q = new PriorityQueue<>(Comparator.comparingInt(a -> a.distToStart));
            q.offer(new State(0, k));
            while (!q.isEmpty()) {
                State cur = q.poll();
                int curId = cur.id;
                int curDistToStart = cur.distToStart;
                // Cut the bigger path if existed
                if (curDistToStart > distTo[curId]) {
                    continue;
                }
                List<int[]> nextList = graph[curId];
                for (int[] next : nextList) {
                    int distToNext = next[1];
                    int nextId = next[0];
                    int nextdistToStart = distToNext + distTo[curId];
                    if (distTo[nextId] > nextdistToStart) {
                        distTo[nextId] = nextdistToStart;
                        q.offer(new State(nextdistToStart, nextId));
                    }
                }
            }
            return distTo;
        }

        private List<int[]>[] buildGraph(int[][] times, int n) {
            List<int[]>[] graph = new List[n + 1];
            for (int i = 0; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }
            for (int[] edge : times) {
                int from = edge[0];
                int to = edge[1];
                int weight = edge[2];
                graph[from].add(new int[]{to, weight});
            }
            return graph;

        }

        class Edge {
            int to;
            int weight;

            public Edge(int to, int weight) {
                this.to = to;
                this.weight = weight;
            }
        }

        class State {
            int distToStart;
            int id;

            public State(int distToStart, int id) {
                this.distToStart = distToStart;
                this.id = id;
            }

        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P743NetworkDelayTime().new Solution();
        // put your test code here

    }
}
