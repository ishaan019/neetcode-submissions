class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;

        int[] newNums = new int[n + 2];
        newNums[0] = 1;
        newNums[n + 1] = 1;

        for(int i = 0; i < n; i++) {
            newNums[i + 1] = nums[i];
        }

        int[][] dp = new int[n + 2][n + 2];
        for(int[] i : dp) {
            Arrays.fill(i, -1);
        }

        return dfs(newNums, 1, newNums.length - 2, dp);
    }

    int dfs(int[] nums, int l, int r, int[][] dp) {
        if(l > r) {
            return 0;
        }

        if(dp[l][r] != -1) {
            return dp[l][r];
        }

        int maxCoins = 0;
        for(int i = l; i <= r; i++) {
            int coins = nums[l - 1] * nums[i] * nums[r + 1];
            coins += dfs(nums, l, i - 1, dp) + dfs(nums, i + 1, r, dp);
            maxCoins = Math.max(maxCoins, coins);
        }

        dp[l][r] = maxCoins;

        return maxCoins;
    }
}
