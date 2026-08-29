class Solution {
    public int findTargetSumWays(int[] nums, int target) {

        Map<String, Integer> dp = new HashMap<>();

        return dfs(0, 0, nums, target, dp);
        
    }

    int dfs(int i, int currSum, int[] nums, int target, Map<String, Integer> dp) {
        if(i == nums.length && currSum == target) {
            return 1;
        }

        if(i >= nums.length) {
            return 0;
        }

        String key = i + "_" + currSum;

        if(dp.containsKey(key)) {
            return dp.get(key);
        }

        int ans = 0;

        int val = nums[i];

        //positive val
        ans += dfs(i + 1, currSum + val, nums, target, dp);

        //negative val
        ans += dfs(i + 1, currSum - val, nums, target, dp);

        dp.put(key, ans);

        return ans;
    }
}
