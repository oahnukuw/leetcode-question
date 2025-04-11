package leetcode.editor.cn;

public class P1700NumberOfStudentsUnableToEatLunch {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countStudents(int[] students, int[] sandwiches) {
            int[] studentCount = new int[2];
            for (int type : students) {
                studentCount[type]++;
            }
            for (int type : sandwiches) {
                if (studentCount[type] == 0) {
                    return studentCount[0] + studentCount[1];
                }
                studentCount[type]--;
            }
            return 0;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P1700NumberOfStudentsUnableToEatLunch().new Solution();
        // put your test code here

    }
}
