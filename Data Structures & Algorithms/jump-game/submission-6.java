class Solution {
    public boolean canJump(int[] nums) {
        // nums = [1,2,0,1,0]
        // dp.  = [T,T,F,T,T]

        // nums = [1,2,1,0,1]
        // dp.  = [F,F,F,F,T]

        int N = nums.length;

        boolean[] dp = new boolean[N];
        dp[N - 1] = true;

        for (int i = N - 2; i >= 0; i--) {
            if (i + nums[i] >= N - 1) {
                dp[i] = true;
            }

            for(int j = i; j <= i + nums[i]; j++) {
                if(dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[0];
    }
}
