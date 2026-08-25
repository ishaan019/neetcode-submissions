class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][nums.length + 1]; //[idx][prevIdx]
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }
        return dfs(0, -1, nums, dp);
    }

    int dfs(int idx, int prevIdx, int[] nums, int[][] dp) {
        if (idx == nums.length) {
            return 0;
        }

        if(dp[idx][prevIdx + 1] != -1) {
            return dp[idx][prevIdx + 1];
        }

        // not take
        int len = dfs(idx + 1, prevIdx, nums, dp);

        if (prevIdx == -1 || nums[idx] > nums[prevIdx]) {
            // take
            len = Math.max(len, 1 + dfs(idx + 1, idx, nums, dp));
        }
        dp[idx][prevIdx + 1] = len;
        return len;
    }
}
