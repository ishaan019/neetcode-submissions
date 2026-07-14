class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> dp = new HashMap<>();

        return dfs(0, 0, nums, target, dp);
        
    }

    int dfs(int i, int currSum, int[] nums, int target, Map<String, Integer> dp) {
        if(i == nums.length) {
            return currSum == target ? 1 : 0;
        }
    
        String key = i + "_" + currSum;

        if(dp.containsKey(key)) {
            return dp.get(key);
        }

        dp.put(key, dfs(i + 1, currSum + nums[i], nums, target, dp) 
                + dfs(i + 1, currSum - nums[i], nums, target, dp));
        return dp.get(key);
    }
}
