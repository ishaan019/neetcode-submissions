class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;

        int finalSum = (n * (n + 1) ) / 2;
        
        int localSum = 0;

        for(int i = 0; i < n; i++) {
            localSum += nums[i];
        }

        return finalSum - localSum;
    }
}
