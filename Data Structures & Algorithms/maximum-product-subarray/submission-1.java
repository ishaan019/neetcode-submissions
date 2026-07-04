class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;

        int currMax = 1;
        int currMin = 1;
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int tempMax = currMax * nums[i];
            int tempMin = currMin * nums[i];

            currMax = Math.max(Math.max(tempMax, tempMin), nums[i]);

            currMin = Math.min(Math.min(tempMax, tempMin), nums[i]);

            ans = Math.max(currMax, ans);
        }

        return ans;
    }
}