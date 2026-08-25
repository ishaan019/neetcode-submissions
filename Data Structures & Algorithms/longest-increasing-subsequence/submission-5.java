class Solution {
    public int lengthOfLIS(int[] nums) {
        // int[][] dp = new int[nums.length][nums.length + 1]; //[idx][prevIdx]
        // for (int[] i : dp) {
        //     Arrays.fill(i, -1);
        // }
        // return dfs(0, -1, nums, dp);

        //Bottom Up
        // 1. base case
        // 2. write the changing parameters in opposite fashion (idx, prevIdx)
        //  idx = n - 1 to 0
        //  prevIdx = idx - 1 to -1
        /// 3. Copy the reccurance and make sure you follow the coordinate shift

        // int[][] dp = new int[nums.length + 1][nums.length + 1]; //[idx][prevIdx]

        // for (int idx = nums.length - 1; idx >= 0; idx--) {
        //     for (int prevIdx = idx - 1; prevIdx >= -1; prevIdx--) {
        //         // not take
        //         int len = dp[idx + 1][prevIdx + 1];

        //         if (prevIdx == -1 || nums[idx] > nums[prevIdx]) {
        //             // take
        //             len = Math.max(len, 1 + dp[idx + 1][idx + 1]);
        //         }
        //         dp[idx][prevIdx + 1] = len;
        //     }
        // }

        // return dp[0][-1+1];


        //If dp[idx + 1] is present in row. you can space optimize it to n
        //make dp[idx][xyz] -> curr[xyz]
        //make dp[idx + 1][xyz] -> next[xyz]
        // Bottom up space optimized
        int[] curr = new int[nums.length + 1]; //[idx][prevIdx]
        int[] next = new int[nums.length + 1];

        for (int idx = nums.length - 1; idx >= 0; idx--) {
            for (int prevIdx = idx - 1; prevIdx >= -1; prevIdx--) {
                // not take
                int len = next[prevIdx + 1];

                if (prevIdx == -1 || nums[idx] > nums[prevIdx]) {
                    // take
                    len = Math.max(len, 1 + next[idx + 1]);
                }
                curr[prevIdx + 1] = len;
            }
            next = curr;
        }

        return next[0];
    }

    // int dfs(int idx, int prevIdx, int[] nums, int[][] dp) {
    //     if (idx == nums.length) {
    //         return 0;
    //     }

    //     if (dp[idx][prevIdx + 1] != -1) {
    //         return dp[idx][prevIdx + 1];
    //     }

    //     // not take
    //     int len = dfs(idx + 1, prevIdx, nums, dp);

    //     if (prevIdx == -1 || nums[idx] > nums[prevIdx]) {
    //         // take
    //         len = Math.max(len, 1 + dfs(idx + 1, idx, nums, dp));
    //     }
    //     dp[idx][prevIdx + 1] = len;
    //     return len;
    // }
}
