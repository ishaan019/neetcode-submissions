class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        Arrays.fill(dp, -1);

        return dfs(cost.length, cost, dp);
    }

    int dfs(int n, int[] cost, int[] dp) {
        if (n == 0) {
            return cost[n];
        }

        if (n < 0) {
            return 0;
        }

        if(dp[n] != -1) {
            return dp[n];
        }

        int val1 = dfs(n - 1, cost, dp);

        int val2 = dfs(n - 2, cost, dp);

        int ans = Math.min(val1, val2);

        if (n < cost.length) {
            ans += cost[n];
        }

        dp[n] = ans;
        return ans;
    }
}
