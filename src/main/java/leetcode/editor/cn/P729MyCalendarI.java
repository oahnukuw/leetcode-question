package leetcode.editor.cn;

import java.util.TreeMap;

public class P729MyCalendarI {

    // leetcode submit region begin(Prohibit modification and deletion)
    class MyCalendar {
        TreeMap<Integer, Integer> calendar;
        public MyCalendar() {
            calendar = new TreeMap<>();
        }

        public boolean book(int startTime, int endTime) {
            Integer earlier = calendar.floorKey(startTime);
            Integer later = calendar.ceilingKey(startTime);

            if (later != null && endTime > later) {
                return false;
            }

            if (earlier != null && calendar.get(earlier) > startTime) {
                return false;
            }
            calendar.put(startTime, endTime);
            return true;

        }
    }

    /**
     * Your MyCalendar object will be instantiated and called as such:
     * MyCalendar obj = new MyCalendar();
     * boolean param_1 = obj.book(startTime,endTime);
     */
    // leetcode submit region end(Prohibit modification and deletion)
    public static void main(String[] args) {
        // put your test code here

    }
}
