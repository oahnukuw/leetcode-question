package leetcode.editor.cn;

import java.util.*;

public class P388LongestAbsoluteFilePath {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthLongestPath(String input) {
            String[] split = input.split("\n");
            Stack<String> filepath = new Stack<>();
            int res = 0;
            for (String part : split) {
                int level = part.lastIndexOf('\t') + 1;
                while (level < filepath.size()) {
                    filepath.pop();
                }
                String substring = part.substring(level);
                filepath.push(substring);
                if (substring.contains(".")) {
                    int sum = filepath.stream().mapToInt(String::length).sum() + level;
                    res = Math.max(sum, res);
                }
            }
            return res;
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
