class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return dfs(0, nums, dp);
        
    }

    int dfs(int i, int[] nums, int[] dp) {
        if(i >= nums.length) {
            return 0;
        }

        if(dp[i] != -1) {
            return dp[i];
        }

        int nextHouse = dfs(i + 1, nums, dp);
        int thisAndThirdHouse = nums[i] + dfs(i + 2, nums, dp);

        int ans = Math.max(nextHouse, thisAndThirdHouse);
        dp[i] = ans;
        return ans;
    }
}
