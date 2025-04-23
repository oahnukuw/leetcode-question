package leetcode.editor.cn;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P127WordLadder {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            HashSet<String> wordSet = new HashSet<>(wordList);
            if (!wordSet.contains(endWord)) {
                return 0;
            }
            Queue<String> q = new LinkedList<>();
            HashSet<String> visited = new HashSet<>();
            q.offer(beginWord);
            visited.add(beginWord);
            int step = 1;
            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    String cur = q.poll();
                    char[] ch = cur.toCharArray();
                    for (int j = 0; j < ch.length; j++) {
                        char originChar = ch[j];
                        for (char c = 'a'; c <= 'z'; c++) {
                            ch[j] = c;
                            String nextWrod = String.valueOf(ch);
                            if (wordSet.contains(nextWrod) && !visited.contains(nextWrod)) {
                                if (nextWrod.equals(endWord)) {
                                    return step + 1;
                                }
                                q.offer(nextWrod);
                                visited.add(nextWrod);
                            }
                        }
                        ch[j] = originChar;
                    }
                }
                step++;
            }
            return 0;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P127WordLadder().new Solution();
        // put your test code here

    }
}
