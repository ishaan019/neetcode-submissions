class Solution {
    int[][] dirs = {{1, 0}, {0, 1}};
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for(int[] a : dp) {
            Arrays.fill(a, -1);
        }

        return dfs(0, 0, m, n, dp);
    }

    int dfs(int i, int j, int m, int n, int[][] dp) {
        if (i == (m - 1) && j == (n - 1)) {
            return 1;
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        int ans = 0;

        for (int[] d : dirs) {
            int nr = i + d[0];
            int nc = j + d[1];

            if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                ans += dfs(nr, nc, m, n, dp);
            }
        }

        dp[i][j] = ans;

        return ans;
    }
}
