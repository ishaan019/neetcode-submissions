class Solution {
    private Boolean[][] memo;

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();

        if (sum % 2 != 0) {
            return false;
        }

        int half = sum / 2;
        memo = new Boolean[nums.length][half + 1];
        return dfs(nums, 0, half, 0);
    }

    boolean dfs(int[] nums, int i, int totalSum, int currSum) {
        if (currSum == totalSum) {
            return true;
        }

        if (i >= nums.length) {
            return false;
        }
        if (currSum > totalSum) {
            return false;
        }

        if (memo[i][currSum] != null) {
            return memo[i][currSum];
        }

        // lena hai || //nhi lena hai
        memo[i][currSum] = dfs(nums, i + 1, totalSum, currSum + nums[i])
                || dfs(nums, i + 1, totalSum, currSum);

        return memo[i][currSum];
    }
}
