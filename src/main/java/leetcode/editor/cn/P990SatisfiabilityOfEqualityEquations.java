package leetcode.editor.cn;

public class P990SatisfiabilityOfEqualityEquations {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean equationsPossible(String[] equations) {
            UF uf = new UF(26);
            for (String equation : equations) {
                int a = equation.charAt(0) - 'a';
                int b = equation.charAt(3) - 'a';
                char equal = equation.charAt(1);
                if (equal == '=') {
                    uf.union(a, b);
                }
            }
            for (String equation : equations) {
                int a = equation.charAt(0) - 'a';
                int b = equation.charAt(3) - 'a';
                char equal = equation.charAt(1);
                if (equal == '!') {
                    if (uf.connected(a, b)) {
                        return false;
                    }
                }
            }
            return true;

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
                    parent[rootQ] = parent[p];
                }
            }

            private int find(int x) {
                if (parent[x] != x) {
                    parent[x] = find(parent[x]);
                }
                return parent[x];
            }

            private boolean connected(int p, int q) {
                int rootP = find(p);
                int rootQ = find(q);
                return rootQ == rootP;
            }
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P990SatisfiabilityOfEqualityEquations().new Solution();
        // put your test code here

    }
}
