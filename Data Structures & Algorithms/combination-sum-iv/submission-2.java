class Solution {
    public int combinationSum4(int[] nums, int target) {

        int dp[] = new int[target + 1];
        Arrays.fill(dp, -1);

        return dfs(nums, target, dp, 0);
    }

    int dfs(int[] nums, int target, int[] dp, int i) {
        
        if (target == 0) {
            return 1;
        }

        if (target < 0 || i == nums.length) {
            return 0;
        }
        
        if(i == 0 && dp[target] != -1) {
            return dp[target];
        }

        int skip = dfs(nums, target, dp, i + 1);

        int use = dfs(nums, target - nums[i], dp, 0);

        int result = skip + use;

        if(i == 0) {
            dp[target] = result;
        }

        return result;
    }
}