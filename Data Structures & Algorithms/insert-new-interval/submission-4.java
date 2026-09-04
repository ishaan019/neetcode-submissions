class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int N = intervals.length;

        List<int[]> ans = new ArrayList<>();

        int i = 0;

        while(i < N && intervals[i][1] < newInterval[0]) {
            ans.add(intervals[i]);
            i++;
        }

        while(i < N && newInterval[0] <= intervals[i][1] && newInterval[1] >= intervals[i][0]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        ans.add(newInterval);

        while(i < N) {
            ans.add(intervals[i]);
            i++;
        }

        int[][] res = new int[ans.size()][2];

        int j = 0;
        for(int[] arr : ans) {
            res[j] = arr;
            j++;
        }

        return res;

        //it will intersact
        //min(prev.start, curr.start)
        //max(prev.end, curr.end)

        //it will not intersact
        //add the interval
        
    }
}
