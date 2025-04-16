package leetcode.editor.cn;

import java.util.*;

public class P1584MinCostToConnectAllPoints {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minCostConnectPoints(int[][] points) {
            List<int[]> edges = new ArrayList<>();
            int n = points.length;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int xi = points[i][0], yi = points[i][1];
                    int xj = points[j][0], yj = points[j][1];
                    int weight = Math.abs(xi - xj) + Math.abs(yi - yj);
                    edges.add(new int[]{i, j, weight});
                }
            }
            UF uf = new UF(n);
            Collections.sort(edges, Comparator.comparingInt(a -> a[2]));
            int mst = 0;
            for (int[] edge : edges) {
                int p = edge[0], q = edge[1], weight = edge[2];
                if (!uf.connected(q, p)) {
                    uf.union(q, p);
                    mst += weight;
                }
            }
            return mst;

        }

        class UF {
            int[] parent;
            int count;

            public UF(int n) {
                parent = new int[n];
                count = n;
                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                }
            }

            public void union(int p, int q) {
                int rootP = find(p);
                int rootQ = find(q);
                if (rootQ != rootP) {
                    parent[rootP] = rootQ;
                    count--;
                }
            }

            private int find(int x) {
                if (parent[x] != x) {
                    parent[x] = find(parent[x]);
                }
                return parent[x];
            }

            public boolean connected(int q, int p) {
                int rootQ = find(q);
                int rootP = find(p);
                return rootP == rootQ;
            }

            public int count() {
                return count;
            }

        }

    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P1584MinCostToConnectAllPoints().new Solution();
        // put your test code here

    }
}
