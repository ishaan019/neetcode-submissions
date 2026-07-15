class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;

        int maxLength = Integer.MIN_VALUE;

        Map<String, Integer> dp = new HashMap<>();

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                int pathLength = dfs(i, j, matrix, Integer.MIN_VALUE, dp);
                maxLength = Math.max(maxLength, pathLength);
            }
        }

        return maxLength;
    }

    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private int dfs(int i, int j, int[][] matrix, int prevVal, Map<String, Integer> dp) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;

        if (i < 0 || i >= ROWS || j < 0 || j >= COLS || matrix[i][j] <= prevVal) {
            return 0;
        }

        String key = "i=" + i + "j=" + j;
        if(dp.containsKey(key)) {
            return dp.get(key);
        }

        int res = 1;
        for (int[] d : dirs) {
            int nr = i + d[0];
            int nc = j + d[1];

            res = Math.max(res, 1 + dfs(nr, nc, matrix, matrix[i][j], dp));
            dp.put(key, res);
        }

        // return res;
        return dp.get(key);
    }
}