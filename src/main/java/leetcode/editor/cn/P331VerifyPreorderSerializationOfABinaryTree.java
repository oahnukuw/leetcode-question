package leetcode.editor.cn;

public class P331VerifyPreorderSerializationOfABinaryTree {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValidSerialization(String preorder) {
            String[] split = preorder.split(",");
            int edge = 1;
            for (String s : split) {
                if (s.equals("#")) {
                    edge--;
                    if (edge < 0) return false;
                } else {
                    edge--;
                    if (edge < 0) return false;
                    edge += 2;
                }
            }
            return edge == 0;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P331VerifyPreorderSerializationOfABinaryTree().new Solution();
        // put your test code here

    }
}
