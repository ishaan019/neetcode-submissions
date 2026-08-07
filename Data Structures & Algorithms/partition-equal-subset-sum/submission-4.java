class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();

        if (sum % 2 != 0) {
            return false;
        }

        int half = sum / 2;
        return dfs(nums, 0, half, 0);
    }

    boolean dfs(int[] nums, int i, int totalSum, int currSum) {
        if (i >= nums.length) {
            return false;
        }
        if(currSum > totalSum) {
            return false;
        }
        if (currSum == totalSum) {
            return true;
        }

        // lena hai || //nhi lena hai
        return dfs(nums, i + 1, totalSum, currSum + nums[i])
            || dfs(nums, i + 1, totalSum, currSum);
    }
}
