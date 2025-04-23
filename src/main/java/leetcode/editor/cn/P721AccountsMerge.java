package leetcode.editor.cn;

import java.util.*;

public class P721AccountsMerge {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> accountsMerge(List<List<String>> accounts) {
            HashMap<String, List<Integer>> emailToIndex = new HashMap<>();
            // key: Email value: index in accounts
            for (int i = 0; i < accounts.size(); i++) {
                List<String> emails = accounts.get(i);
                for (int j = 1; j < emails.size(); j++) {
                    String key = emails.get(j);
                    emailToIndex.putIfAbsent(key, new ArrayList<>());
                    emailToIndex.get(key).add(i);
                }
            }
            HashSet<String> visited = new HashSet<>();
            List<List<String>> res = new ArrayList<>();

            for (String email : emailToIndex.keySet()) {
                if (visited.contains(email)) {
                    continue;
                }
                Queue<String> q = new LinkedList<>();
                LinkedList<String> mergedEmail = new LinkedList<>();
                q.offer(email);
                visited.add(email);
                while (!q.isEmpty()) {
                    String cur = q.poll();
                    mergedEmail.add(cur);
                    List<Integer> indexes = emailToIndex.get(cur);
                    for (Integer index : indexes) {
                        List<String> account = accounts.get(index);
                        for (int i = 1; i < account.size(); i++) {
                            String nextEmail = account.get(i);
                            if (!visited.contains(nextEmail)) {
                                q.offer(nextEmail);
                                visited.add(nextEmail);
                            }
                        }
                    }
                }
                String userName = accounts.get(emailToIndex.get(email).get(0)).get(0);
                Collections.sort(mergedEmail);
                mergedEmail.addFirst(userName);
                res.add(mergedEmail);
            }
            return res;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P721AccountsMerge().new Solution();
        // put your test code here

    }
}
