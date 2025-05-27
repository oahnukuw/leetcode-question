package leetcode.editor.template;

import leetcode.editor.ds.Graph;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Dijkstra {
    class State {
        // 当前节点 ID
        int node;
        // 从起点 s 到当前 node 节点的最小路径权重和
        int distFromStart;

        public State(int node, int distFromStart) {
            this.node = node;
            this.distFromStart = distFromStart;
        }
    }

    // 输入不包含负权重边的加权图 graph 和起点 src
// 返回从起点 src 到其他节点的最小路径权重和
    int[] dijkstra(Graph graph, int src) {
        // 记录从起点 src 到其他节点的最小路径权重和
        // distTo[i] 表示从起点 src 到节点 i 的最小路径权重和
        int[] distTo = new int[graph.size()];

        // 因为不包含负权重边，所以初始化 distTo 数组的值都为 -1
        // 这样就能区分节点是否被访问过
        Arrays.fill(distTo, -1);

        // 优先级队列，distFromStart 较小的节点排在前面
        Queue<State> pq = new PriorityQueue<>((a, b) -> {
            return a.distFromStart - b.distFromStart;
        });

        // 从起点 src 开始进行 BFS
        pq.offer(new State(src, 0));

        while (!pq.isEmpty()) {
            State state = pq.poll();
            int curNode = state.node;
            int curDistFromStart = state.distFromStart;

            if (distTo[curNode] != -1) {
                // 注意这个判断条件，和标准 BFS 算法不同
                // 因为在 Dijkstra 算法中，队列中可能存在重复的节点 state
                // 根据贪心思想，第一次出队的节点 state 才是从 src 到该节点的最小路径权重和
                continue;
            }

            // curNode 节点第一次出队时，就找到了从 src 到 curNode 的最小路径权重和
            // 更新 distTo[curNode]
            distTo[curNode] = curDistFromStart;

            for (leetcode.editor.ds.Edge e : graph.neighbors(curNode)) {
                int nextNode = e.to;
                int nextDistFromStart = curDistFromStart + e.weight;

                if (distTo[nextNode] != -1) {
                    continue;
                }

                // 将 nextNode 节点加入优先级队列
                pq.offer(new State(nextNode, nextDistFromStart));
                // 注意这里也和标准 BFS 算法不同
                // 我们不能在入队时更新 distTo[nextNode]
                // 因为只有在出队时才可能找到最短路径，才能更新 distTo 数组
                // 所以 Dijkstra 算法中，队列内可能存在重复的节点 state
            }
        }

        return distTo;
    }

}
