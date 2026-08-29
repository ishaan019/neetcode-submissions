class Solution {
    public int maxCoins(int[] nums) {
        int N = nums.length;//4

        int[] newNums = new int[N + 2];
        newNums[0] = 1;
        newNums[N + 1] = 1;

        for(int i = 1; i <= N; i++) {
            newNums[i] = nums[i - 1];
        }

        int[][] dp = new int[newNums.length][newNums.length];
        for(int[] d : dp) {
            Arrays.fill(d, -1);
        }

        return dfs(1, newNums.length - 2, newNums, dp);
    }

    int dfs(int l, int r, int[] nums, int[][] dp) {
        if(l > r) {
            return 0;
        }

        if(dp[l][r] != -1){
            return dp[l][r];
        }

        int maxCost = 0;

        for(int i = l; i <= r; i++) {
            int cost = nums[l - 1] * nums[i] * nums[r + 1];
            int leftCost = dfs(l, i - 1, nums, dp);
            int rightCost = dfs(i + 1, r, nums, dp);
            cost += leftCost + rightCost;

            maxCost = Math.max(maxCost, cost);
        }

        dp[l][r] = maxCost;

        return maxCost;

    }
}
