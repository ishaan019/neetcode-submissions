class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];
        for(int i = 1; i < n; i++) {
            prefixSum[i] = nums[i] * prefixSum[i - 1];
        }

        int[] suffixSum = new int[n];
        suffixSum[n - 1] = nums[n - 1];
        for(int i = n - 2; i >= 0; i--) {
            suffixSum[i] = nums[i] * suffixSum[i + 1];
        }

        for(int i = 0; i < n; i++) {
            if(i == 0) {
                nums[i] = suffixSum[i + 1];
            } else if(i == n - 1) {
                nums[i] = prefixSum[i - 1];
            } else {
                nums[i] = prefixSum[i - 1] * suffixSum[i + 1];
            }
        }

        return nums;
    }
}  
