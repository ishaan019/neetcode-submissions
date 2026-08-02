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
    public int minMeetingRooms(List<Interval> intervals) {
        int N = intervals.size();

        int[] start = new int[N];
        int[] end = new int[N];

        int j = 0;
        for (Interval i : intervals) {
            start[j] = i.start;
            end[j] = i.end;
            j++;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int count = 0;
        int ans = 0;
        int s = 0;
        int e = 0;

        while(s < N) {
            if(start[s] < end[e]) {
                s++;
                count++;
            } else {
                e++;
                count--;
            }
            ans = Math.max(ans, count);
        }

        return ans;
    }
}
