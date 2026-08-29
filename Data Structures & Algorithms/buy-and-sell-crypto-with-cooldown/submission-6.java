class Solution {
    public int maxProfit(int[] prices) {
        Integer[][] dp = new Integer[prices.length][2];


        return dfs(0, true, prices, dp);
    }

    int dfs(int i, boolean buying, int[] prices, Integer[][] dp) {
        if(i >= prices.length) {
            return 0;
        }
        int j = (buying == true) ? 1 : 0;

        if(dp[i][j] != null) {
            return dp[i][j];
        }

        int ans = 0;

        int skip = dfs(i + 1, buying, prices, dp);

        ans = Math.max(ans, skip);

        if(buying) {
            ans = Math.max(ans, -prices[i] + dfs(i + 1, false, prices, dp));
        } else {
            ans = Math.max(ans, prices[i] + dfs(i + 2, true, prices, dp));
        }

        dp[i][j] = ans;

        return ans;
    }
}
