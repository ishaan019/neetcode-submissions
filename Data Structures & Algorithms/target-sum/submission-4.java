class Solution {
    public int findTargetSumWays(int[] nums, int target) {

        int total = 0;
        for(int n : nums) {
            total += n;
        }

        // Map<String, Integer> dp = new HashMap<>();

        int[][] dp = new int[nums.length][2 * total + 1];

        for(int[] d: dp) {
            Arrays.fill(d, -1);
        }

        return dfs(0, 0, nums, target, dp, total);
        
    }

    int dfs(int i, int currSum, int[] nums, int target, int[][] dp, int offset) {
        if(i == nums.length && currSum == target) {
            return 1;
        }

        if(i >= nums.length) {
            return 0;
        }

        int index = currSum + offset;

        if(dp[i][index] != -1) {
            return dp[i][index];
        }

        int ans = 0;

        int val = nums[i];

        //positive val
        ans += dfs(i + 1, currSum + val, nums, target, dp, offset);

        //negative val
        ans += dfs(i + 1, currSum - val, nums, target, dp, offset);

        dp[i][index] = ans;

        return ans;
    }
}
