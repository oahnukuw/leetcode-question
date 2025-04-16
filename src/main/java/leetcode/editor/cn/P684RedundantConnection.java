package leetcode.editor.cn;

public class P684RedundantConnection {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findRedundantConnection(int[][] edges) {
            UF uf = new UF(edges.length+1);
            for (int i = 0; i < edges.length; i++) {
                int[] edge = edges[i];
                int p = edge[0], q = edge[1];
                if (!uf.conneced(p, q)) {
                    uf.union(p, q);
                } else return edges[i];
            }
            return new int[]{};


        }

        class UF {
            int[] parent;

            public UF(int n) {
                parent = new int[n];
                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                }
            }

            public void union(int p, int q) {
                int rootP = find(p);
                int rootQ = find(q);
                if (rootQ != rootP) {
                    parent[rootQ] = parent[rootP];
                }
            }

            private int find(int x) {
                if (parent[x] != x) {
                    parent[x] = find(parent[x]);
                }
                return parent[x];
            }

            public boolean conneced(int p, int q) {
                int rootP = find(p);
                int rootQ = find(q);
                return rootQ == rootP;
            }

        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P684RedundantConnection().new Solution();
        // put your test code here

    }
}
