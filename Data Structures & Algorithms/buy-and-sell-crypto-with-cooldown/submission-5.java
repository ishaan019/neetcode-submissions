class Solution {
    public int maxProfit(int[] prices) {

        Integer[][][] dp = new Integer[prices.length][2][2];

        return dfs(0, false, false, prices, dp);        
    }

    int dfs(int i, boolean buy, boolean coolDown, int[] prices, Integer[][][] dp) {
        if(i >= prices.length) {
            return 0;
        }

        int holding = buy ? 1 : 0;
        int cooldown = coolDown ? 1 : 0;

        if(dp[i][holding][cooldown] != null) {
            return dp[i][holding][cooldown];
        }

        int ans = 0;

        if(buy == false) {
            //buy
            if(!coolDown) {
                ans = Math.max(ans, -prices[i] + dfs(i + 1, true, coolDown, prices, dp));
            } else {
                ans = Math.max(ans, dfs(i + 1, false, false, prices, dp));
            }

            //skip
            ans = Math.max(ans, dfs(i + 1, false, coolDown, prices, dp));
        } else {

            //sell
            ans = Math.max(ans, prices[i] + dfs(i + 1, false, true, prices, dp));

            //skip
            ans = Math.max(ans, dfs(i + 1, true, coolDown, prices, dp));
        }

        dp[i][holding][cooldown] = ans;

        return ans;
    }
}
