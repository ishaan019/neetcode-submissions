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

        Interval prev = intervals.get(0);

        for (int i = 1; i < N; i++) {
            Interval curr = intervals.get(i);

            if (prev.end > curr.start) {
                return false;
            }

            prev = curr;
        }

        return true;
    }
}
