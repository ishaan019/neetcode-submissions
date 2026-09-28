class Solution {
    public int rob(int[] nums) {
        int N = nums.length;

        if(N == 1) {
            return nums[0];
        }

        int[] dp = new int[N];
        Arrays.fill(dp, -1);

        return dfs(N - 1, nums, dp);
    }

    int dfs(int i, int[] nums, int[] dp) {
        if(i < 0) {
            return 0;
        }

        if(dp[i] != -1) {
            return dp[i];
        }

        int ans = 0;
        
        ans = Math.max(dfs(i - 1, nums, dp), nums[i] + dfs(i - 2, nums, dp));

        dp[i] = ans;
        return dp[i];
    }
}
