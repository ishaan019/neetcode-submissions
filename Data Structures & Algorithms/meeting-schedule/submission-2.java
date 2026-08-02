/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        int N = intervals.size();

        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        if (N == 0) {
            return true;
        }

        for (int i = 0; i < N - 1; i++) {
            Interval prev = intervals.get(i);
            Interval next = intervals.get(i + 1);

            if (prev.end > next.start) {
                return false;
            }

            prev = next;
        }

        return true;
    }
}
