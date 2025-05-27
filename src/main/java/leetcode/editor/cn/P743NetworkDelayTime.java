package leetcode.editor.cn;

import java.util.*;

public class P743NetworkDelayTime {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int networkDelayTime(int[][] times, int n, int k) {
            // 1. build graph by times
            // adj stores int[]{to,weight}
            List<int[]>[] graph = buildGraph(times, n);
            // 2. Use dijkstra
            // the distance from src to the node
            int[] distTo;
            distTo = new int[n + 1];
            Arrays.fill(distTo, -1);
            dijkstra(graph, distTo, k);
            int res = -1;
            for (int i = 1; i <= n; i++) {
                if (distTo[i] == -1) {
                    return -1;
                }
                res = Math.max(distTo[i], res);
            }
            return res;
        }

        private void dijkstra(List<int[]>[] graph, int[] distTo, int src) {
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
            pq.offer(new int[]{src, 0});
            while (!pq.isEmpty()) {
                // cur{to, distToCur}
                int[] cur = pq.poll();
                int curId = cur[0];
                int distToCur = cur[1];

                if (distTo[curId] != -1) {
                    continue;
                }
                distTo[curId] = distToCur;

                for (int[] next : graph[curId]) {
                    int nextId = next[0];
                    int weightFromCur = next[1];
                    int distToNext = distToCur + weightFromCur;

                    if (distTo[nextId] == -1) {
                        pq.offer(new int[]{nextId, distToNext});
                    }
                }
            }
        }

        private List<int[]>[] buildGraph(int[][] times, int n) {
            List<int[]>[] graph = new LinkedList[n + 1];
            for (int i = 1; i <= n; i++) {
                graph[i] = new LinkedList<>();
            }
            for (int[] time : times) {
                int from = time[0];
                int to = time[1];
                int weight = time[2];
                graph[from].add(new int[]{to, weight});
            }
            return graph;
        }

    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P743NetworkDelayTime().new Solution();
        // put your test code here

    }
}
