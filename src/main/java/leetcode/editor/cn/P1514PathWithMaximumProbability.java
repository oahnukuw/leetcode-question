package leetcode.editor.cn;

import java.util.*;

public class P1514PathWithMaximumProbability {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
            List<double[]>[] graph = buildGraph(n, edges, succProb);

            return dijkstra(graph, start_node, end_node);
        }

        private double dijkstra(List<double[]>[] graph, int startNode, int endNode) {
            double[] probTo = new double[graph.length];
            Arrays.fill(probTo, -1);
            PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[1], a[1]));
            pq.offer(new double[]{startNode, 1});
            while (!pq.isEmpty()) {
                double[] cur = pq.poll();
                int curId = (int) cur[0];
                double curProb = cur[1];
                if (probTo[curId] != -1) continue;
                probTo[curId] = curProb;
                if (curId == endNode) {
                    return curProb;
                }

                for (double[] neighbor : graph[curId]) {
                    int nextId = (int) neighbor[0];
                    double nextProb = neighbor[1];
                    if (probTo[nextId] == -1) {
                        pq.offer(new double[]{nextId, curProb * nextProb});
                    }
                }
            }
            return probTo[endNode] == -1 ? 0.0 : probTo[endNode];
        }

        private List<double[]>[] buildGraph(int n, int[][] edges, double[] succProb) {
            LinkedList<double[]>[] graph = new LinkedList[n];
            for (int i = 0; i < graph.length; i++) {
                graph[i] = new LinkedList<>();
            }
            for (int i = 0; i < edges.length; i++) {
                int[] edge = edges[i];
                int from = edge[0];
                int to = edge[1];
                double prob = succProb[i];
                graph[from].add(new double[]{to, prob});
                graph[to].add(new double[]{from, prob});
            }
            return graph;
        }


    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P1514PathWithMaximumProbability().new Solution();
        // put your test code here

    }
}
