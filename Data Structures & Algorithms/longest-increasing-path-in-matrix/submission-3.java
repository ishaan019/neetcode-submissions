class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;

        int maxLength = Integer.MIN_VALUE;

        Map<String, Integer> dp = new HashMap<>();

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                int pathLength = dfs(i, j, matrix, dp);
                maxLength = Math.max(maxLength, pathLength);
            }
        }

        return maxLength;
    }

    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private int dfs(int i, int j, int[][] matrix, Map<String, Integer> dp) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;

        String key = "i=" + i + "j=" + j;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        int res = 1;
        for (int[] d : dirs) {
            int nr = i + d[0];
            int nc = j + d[1];
            if (nr >= 0 && nr < ROWS && 
                nc >= 0 && nc < COLS && 
                matrix[i][j] < matrix[nr][nc]) {
                res = Math.max(res, 1 + dfs(nr, nc, matrix, dp));
            }
        }

        dp.put(key, res);

        return res;
    }
}