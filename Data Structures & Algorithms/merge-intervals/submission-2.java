class Solution {
    public int[][] merge(int[][] intervals) {

        int N = intervals.length;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> res = new ArrayList<>();

        int[] curr = intervals[0];
        for(int i = 1; i < N; i++) {
            int[] next = intervals[i];
            if(curr[1] < next[0]) {
                res.add(curr);
                curr = next;
            } else {
                curr[0] = Math.min(curr[0], next[0]);
                curr[1] = Math.max(curr[1], next[1]);
            }
        }

        res.add(curr);

        int[][] ans = new int[res.size()][2];
        for(int j = 0; j < res.size(); j++) {
            int[] curr1 = res.get(j);
            ans[j][0] = curr1[0];
            ans[j][1] = curr1[1];
        }

        return ans;


        
    }
}
