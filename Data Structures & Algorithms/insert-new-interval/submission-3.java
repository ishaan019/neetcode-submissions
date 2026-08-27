class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int N = intervals.length;

        List<int[]> res = new ArrayList<>();

        int i = 0;

        //left
        while(i < N && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }


        //middle part
        while(i < N && newInterval[0] <= intervals[i][1] && newInterval[1] >= intervals[i][0]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res.add(newInterval);

        //right part
        while(i < N) {
            res.add(intervals[i]);
            i++;
        }

        int[][] ans = new int[res.size()][2];
        for(int j = 0; j < res.size(); j++) {
            int[] curr = res.get(j);
            ans[j][0] = curr[0];
            ans[j][1] = curr[1];
        }

        return ans;
    }
}
