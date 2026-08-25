class Solution {
    int original = 0;
    public int integerBreak(int n) {
        original = n;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[1] = 1;
        return dfs(n, dp);
    }

    int dfs(int n, int[] dp) {
        if(dp[n] != -1) {
            return dp[n];
        }

        int max = (n == original) ? 0 : n;
        for(int i = 1; i < n; i++) {
            max = Math.max(max, dfs(i, dp) * dfs(n - i, dp));
        }

        dp[n] = max;

        return dp[n];
    }
}