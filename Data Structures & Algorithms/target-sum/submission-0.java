class Solution {
    public int findTargetSumWays(int[] nums, int target) {

        return dfs(0, 0, nums, target);
        
    }

    int dfs(int i, int currSum, int[] nums, int target) {
        if(i == nums.length) {
            return currSum == target ? 1 : 0;
        }

        return dfs(i + 1, currSum + nums[i], nums, target) + dfs(i + 1, currSum - nums[i], nums, target);
    }
}
