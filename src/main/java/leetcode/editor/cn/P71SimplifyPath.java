package leetcode.editor.cn;

import java.util.Stack;

public class P71SimplifyPath {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String simplifyPath(String path) {
            String[] parts = path.split("/");
            Stack<String> stack = new Stack<>();
            for (String part : parts) {
                if (part.equals(".") || part.equals("")) {
                    continue;
                }
                if (part.equals("..") ) {
                    if(!stack.isEmpty()){
                        stack.pop();
                    }
                    continue;
                }
                stack.push(part);
            }
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.insert(0, stack.pop()).insert(0, "/");
            }
            return sb.length() == 0 ? "/" : sb.toString();
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P71SimplifyPath().new Solution();
        // put your test code here
        String path = "/home/";
        solution.simplifyPath(path);

    }
}
