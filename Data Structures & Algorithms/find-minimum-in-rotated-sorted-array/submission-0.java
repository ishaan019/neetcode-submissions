class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;

        int low = 0;
        int high = n - 1;

        int res = Integer.MAX_VALUE;

        while(low <= high) {

            if (nums[low] < nums[high]) {
                res = Math.min(res, nums[low]);
                break;
            }

            int mid = (low + high) / 2;
            res = Math.min(res, nums[mid]);

            if(nums[mid] >= nums[low]) {
                //search right
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return res;
    }
}
