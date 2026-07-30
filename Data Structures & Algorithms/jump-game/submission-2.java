class Solution {
    public boolean canJump(int[] nums) {

        int N = nums.length;
        boolean[] dp = new boolean[N];

        dp[N - 1] = true;

        for(int i = N - 2; i >= 0; i--) {
            if(i + nums[i] >= N - 1) {
                dp[i] = true;
            }

            for(int j = i; j <= i + nums[i]; j++) {
                if(dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        for(boolean b : dp) {
            System.out.print(b + " ");
        }

        return dp[0];
        
    }
}
