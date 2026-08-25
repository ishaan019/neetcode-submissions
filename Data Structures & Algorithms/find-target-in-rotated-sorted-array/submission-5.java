class Solution {
    //5,1,2,3,4
    //1
    public int search(int[] nums, int target) {
        // binary search on nums
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {//0<4
            int mid = (low + high) / 2;//2
            int curr = nums[mid];//2

            if (curr == target) {
                return mid;
            }

            //1,2,3,4,5 , 
            //5,1,2,3,4
            // target = 1
            
            // check left part is sorted
            if(nums[low] <= nums[mid]) {
                //your target lies in left sorted part?
                if(target >= nums[low] && target <= nums[mid]) {
                    //search left
                    high = mid - 1;
                } else {
                    //search right
                    low = mid + 1;
                }

            } else {
                //right part must be sorted
                if(target >= nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
                     
        }
        return -1;
    }
}
