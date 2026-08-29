class Solution {
    public int change(int amount, int[] coins) {

        int[][] dp = new int[coins.length][amount + 1];

        for(int[] d : dp) {
            Arrays.fill(d, -1);
        }
        
        return dfs(0, 0, amount, coins, dp);
        
    }

    int dfs(int i, int currSum, int amount, int[] coins, int[][] dp) {

        if(currSum == amount) {
            return 1;
        }

        if(currSum > amount || i >= coins.length) {
            return 0;
        }

        if(dp[i][currSum] != -1) {
            return dp[i][currSum];
        }


        int ans = 0;

        // Take coin[i]
        if (coins[i] <= amount) {
            ans += dfs(i, currSum + coins[i] , amount, coins, dp);
        }

        // Skip coin[i]
        ans += dfs(i + 1, currSum, amount, coins, dp);

        dp[i][currSum] = ans;

        return ans;
    }
}
