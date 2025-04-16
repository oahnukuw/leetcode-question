package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.cn.common.*;

public class P785IsGraphBipartite {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        boolean[] visited;
        boolean[] color;
        boolean ok = true;
        public boolean isBipartite(int[][] graph) {
            int n = graph.length;
            visited = new boolean[n];
            color = new boolean[n];
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    traverseDFS(graph, i);
                }
            }
            return ok;
        }

        private void traverseDFS(int[][] graph, int v) {
            if (!ok) return;

            visited[v] = true;
            int[] neighbors = graph[v];
            for (int w : neighbors) {
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
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new P785IsGraphBipartite().new Solution();
        // put your test code here
        
    }
}
