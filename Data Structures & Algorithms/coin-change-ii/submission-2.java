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

        if(currSum > amount) {
            return 0;
        }

        if(dp[i][currSum] != -1) {
            return dp[i][currSum];
        }


        int ans = 0;

        for(int j = i; j < coins.length; j++) {
            ans += dfs(j, currSum + coins[j], amount, coins, dp);
        }

        dp[i][currSum] = ans;

        return ans;
    }
}
