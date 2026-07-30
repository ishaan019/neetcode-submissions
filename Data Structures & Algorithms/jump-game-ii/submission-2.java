class Solution {
    public int jump(int[] nums) {
        int N = nums.length;

        int[] dp = new int[N];

        dp[N - 1] = 0;

        for (int i = N - 2; i >= 0; i--) {
            int val = nums[i];

            int curr = Integer.MAX_VALUE;
            for (int j = i + 1; j <= Math.min(N - 1, (i + val)); j++) {
                curr = Math.min(curr, dp[j]);
            }

           dp[i] = curr == Integer.MAX_VALUE ? Integer.MAX_VALUE : curr + 1;
        }

        return dp[0];
    }
}
