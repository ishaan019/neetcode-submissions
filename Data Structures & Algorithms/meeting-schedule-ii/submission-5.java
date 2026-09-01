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

        Map<Integer, Integer> events = new TreeMap<>();

        for(Interval i : intervals) {
            int start = i.start;
            int end = i.end;

            events.put(start, events.getOrDefault(start, 0) + 1);
            events.put(end, events.getOrDefault(end, 0) - 1);
        }

        int overlap = 0;
        int maxOverlap = 0;

        // for(Map.Entry<Integer, Integer> entry : events.entrySet()) {
        //     overlap += entry.getValue();
        //     maxOverlap = Math.max(maxOverlap, overlap);
        // }

        for(int key : events.keySet()) {
            overlap += events.get(key);
            maxOverlap = Math.max(maxOverlap, overlap);
        }

        return maxOverlap;
    }
}
