class Solution {
    public int[][] merge(int[][] intervals) {
        int N = intervals.length;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

            List<int[]> res = new ArrayList<>();

        int[] curr = intervals[0];
        for (int i = 1; i < N; i++) {
            int[] temp = intervals[i];
            if (curr[1] < temp[0]) {
                res.add(curr);
                curr = temp;
            } else if (curr[1] >= temp[0]) {
                curr[0] = Math.min(curr[0], temp[0]);
                curr[1] = Math.max(curr[1], temp[1]);
            }
        }

        res.add(curr);

        return res.toArray(new int[res.size()][]);
    }
}
