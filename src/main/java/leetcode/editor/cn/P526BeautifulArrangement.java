package leetcode.editor.cn;

import java.util.LinkedList;

public class P526BeautifulArrangement {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        LinkedList<Integer> track = new LinkedList<>();
        boolean[] visited;
        int res = 0;

        public int countArrangement(int n) {
            visited = new boolean[n + 1];
            backtrack(n);
            return res;
        }

        private void backtrack(int n) {
            if (track.size() == n) {
                res++;
                return;
            }
            for (int i = 1; i <= n; i++) {
                if(visited[i]) continue;
                if ((track.size() + 1) % i != 0 && i % (track.size() + 1) != 0) {
                    continue;
                }
                track.add(i);
                visited[i] = true;
                backtrack(n);
                track.removeLast();
                visited[i] = false;
            }
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P526BeautifulArrangement().new Solution();
        // put your test code here

    }
}
