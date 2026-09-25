class Solution {
    public int climbStairs(int n) {
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        dfs(n, dp);

        return dp[n];
    }

    int dfs(int n, int[] dp) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }

        if(dp[n] != -1) {
            return dp[n];
        }

        int ans = 0;
        ans = dfs(n - 1, dp) + dfs(n - 2, dp);

        dp[n] = ans;
        return ans;
    }
}
