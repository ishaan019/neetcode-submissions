class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int N = cost.length;

        int[] dp = new int[N + 1];

        dp[0] = cost[0];
        dp[1] = Math.min(cost[1], cost[0] + cost[1]);

        for (int i = 2; i < N; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }

        return Math.min(dp[N - 2], dp[N - 1]);
    }
}
