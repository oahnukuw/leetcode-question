package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class P388LongestAbsoluteFilePath {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthLongestPath(String input) {
            String[] parts = input.split("\n");
            Deque<String> stack = new ArrayDeque<>(parts[parts.length - 1].lastIndexOf("\t") + 1);
            int maxLen = 0;
            for (String part : parts) {
                int level = part.lastIndexOf("\t") + 1;
                while (level < stack.size()) {
                    stack.pop();
                }
                stack.push(part.substring(level));
                if (part.contains(".")) {
                    int sum = stack.stream().mapToInt(String::length).sum();
                    sum += stack.size() - 1;
                    maxLen = Math.max(maxLen, sum);
                }
            }
            return maxLen;

        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P388LongestAbsoluteFilePath().new Solution();
        // put your test code here
        String s = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
        solution.lengthLongestPath(s);

    }
}
