class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int N = cost.length;

        int[] dp = new int[N + 1];
        Arrays.fill(dp, -1);

        return dfs(N, cost, dp);
    }

    int dfs(int n, int[] cost, int[] dp) {//cost = [1,2,3]

        if( n == 0) {
            return cost[0];
        } 

        if(n == 1) {
            return cost[1];
        }

        if( n < 0) {
            return Integer.MAX_VALUE;
        }

        if(dp[n] != -1) {
            return dp[n];
        }

        int ans = 0;
        ans = Math.min(dfs(n - 1, cost, dp), dfs(n - 2, cost, dp));

        if(n != cost.length) {
            ans += cost[n];
        }

        dp[n] = ans;
        return dp[n];
    }

}
