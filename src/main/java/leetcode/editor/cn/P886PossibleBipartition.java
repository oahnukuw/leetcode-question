package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.cn.common.*;

public class P886PossibleBipartition {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        boolean[] visited;
        boolean[] color;
        boolean ok = true;
        public boolean possibleBipartition(int n, int[][] dislikes) {
            List<Integer>[] graph = buildGraph(n, dislikes);
            visited = new boolean[n+1];
            color = new boolean[n+1];
            for (int i = 1; i < graph.length; i++) {
                if (!visited[i]) {
                    traverseDFS(graph, i);
                }
            }
            return ok;
        }

        private void traverseDFS(List<Integer>[] graph, int v) {
            if (!ok) return;
            visited[v] = true;
            for (Integer w : graph[v]) {
                if (!visited[w]) {
                    color[w] = !color[v];
                    traverseDFS(graph, w);
                } else {
                    if (color[w] == color[v]) {
                        ok = false;
                        return;
                    }
                }
            }
        }

        private List<Integer>[] buildGraph(int n, int[][] dislikes) {
            List<Integer>[] graph = new List[n+1];
            for (int i = 1; i < graph.length; i++) {
                graph[i] = new LinkedList<>();
            }
            for (int[] edge : dislikes) {
                int from = edge[0], to = edge[1];
                graph[from].add(to);
                graph[to].add(from);
            }
            return graph;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new P886PossibleBipartition().new Solution();
        // put your test code here
        
    }
}
