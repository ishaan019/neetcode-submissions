class Solution {
    Boolean[][] memo;
    public boolean canPartition(int[] nums) {
        int n = nums.length;

        int sum = Arrays.stream(nums).sum();
        boolean isEven = sum % 2 == 0 ? true : false;
        if (!isEven) {
            return false;
        }
        int target = sum / 2;

        memo = new Boolean[n][target + 1];

        return dfs(0, n, target, nums);
    }

    boolean dfs(int i, int n, int target, int[] nums) {
        if (target == 0) {
            return true;
        }
        if (target < 0) {
            return false;
        }
        if (i == n) {
            return target == 0;
        }

        if(memo[i][target] != null) {
            return memo[i][target];
        }

        memo[i][target] = dfs(i + 1, n, target, nums) || dfs(i + 1, n, target - nums[i], nums);

        return memo[i][target];
    }
}
