package leetcode.editor.cn;

import java.util.*;

public class P1514PathWithMaximumProbability {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
            List<Edge>[] graph = buildGraph(n, edges, succProb);
            return dijkstra(graph, start_node, end_node);
        }

        private double dijkstra(List<Edge>[] graph, int start, int end) {
            double[] propFrom = new double[graph.length];
            Arrays.fill(propFrom, -1);
            propFrom[start] = 1;
            PriorityQueue<Edge> q = new PriorityQueue<>((a, b) -> (Double.compare(b.prob, a.prob)));
            q.offer(new Edge(start, 1));

            while (!q.isEmpty()) {
                Edge curNode = q.poll();
                int curId = curNode.id;
                double curProp = curNode.prob;

                if (curId == end) {
                    // return propFrom[end] == -1 ? 0 : propFrom[end];
                    return propFrom[end];
                }
                if (curProp < propFrom[curId]) {
                    continue;
                }
                List<Edge> nextEdges = graph[curId];
                for (Edge next : nextEdges) {
                    double nextPropFrom = next.prob * propFrom[curId];
                    if (nextPropFrom > propFrom[next.id]) {
                        propFrom[next.id] = nextPropFrom;
                        q.offer(new Edge(next.id, nextPropFrom));
                    }
                }
            }
            return 0;
        }

        private List<Edge>[] buildGraph(int n, int[][] edges, double[] succProb) {
            List<Edge>[] graph = new List[n];
            for (int i = 0; i < graph.length; i++) {
                graph[i] = new ArrayList<>();
            }
            for (int i = 0; i < edges.length; i++) {
                int[] edge = edges[i];
                int w = edge[0], v = edge[1];
                graph[w].add(new Edge(v, succProb[i]));
                graph[v].add(new Edge(w, succProb[i]));
            }
            return graph;
        }

        class Edge {
            int id;
            double prob;

            public Edge(int id, double prob) {
                this.id = id;
                this.prob = prob;
            }
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P1514PathWithMaximumProbability().new Solution();
        // put your test code here

    }
}
