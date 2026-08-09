class Solution {
    public int combinationSum4(int[] nums, int target) {

        int dp[] = new int[target + 1];

        return dfs(nums, target, dp);
    }

    int dfs(int[] nums, int target, int[] dp) {
        if (target < 0) {
            return 0;
        }
        if (target == 0) {
            return 1;
        }

        if(dp[target] != 0) {
            return dp[target];
        }

        int ans = 0;

        for (int j = 0; j < nums.length; j++) {
            ans += dfs(nums, target - nums[j], dp);
        }
        dp[target] = ans;
        return dp[target];
    }
}