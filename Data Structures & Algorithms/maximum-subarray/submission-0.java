class Solution {
    public int maxSubArray(int[] nums) {
        int N = nums.length;

        int maxSum = Integer.MIN_VALUE;

        int currSum = 0;

        for(int i = 0; i < N; i++) {
            currSum += nums[i];

            currSum = Math.max(currSum, nums[i]);

            maxSum = Math.max(currSum, maxSum);
        }

        return maxSum;
    }
}
