class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;

        int l = 0;
        int r = n - 1;

        while (l <= r) {
            int m = (l + r) / 2;

            if (target == nums[m]) {
                return m;
            }

            // left portion
            if (nums[l] <= nums[m]) {
                if (target > nums[m] || target < nums[l]) {
                    // search right
                    l = m + 1;
                } else {
                    // search left
                    r = m - 1;
                }
            } else {
                if (target < nums[m] || target > nums[r]) {
                    // search left
                    r = m - 1;
                } else {
                    // search right
                    l = m + 1;
                }
            }
        }
        return -1;
    }
}
