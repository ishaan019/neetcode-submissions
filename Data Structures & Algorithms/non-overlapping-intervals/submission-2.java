class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int N = intervals.length;

        if(N <= 1) {
            return 0;
        }
        
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        int prevEnd = intervals[0][1];

        int ans = 0;

        for(int i = 1; i < N; i++) {
            int[] curr = intervals[i];
            int start = curr[0];
            int end = curr[1];

            if(start < prevEnd) {
                ans++;
                prevEnd = Math.min(end, prevEnd);
            } else {
                prevEnd = end;
            }
        }
        return ans;
    }
}
