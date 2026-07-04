class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < n - 2; i++) {//O(n)
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int curr = nums[i];
            int target = -curr;
            
            int j = i + 1;
            int k = n - 1;
            while(j < k) {//O(n)
                List<Integer> list = new ArrayList<>();
                int sum = nums[j] + nums[k];
                if(sum == target) {
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    
                    result.add(list);
                    
                    while(j < k && nums[j] == nums[j + 1]) j++;
                    while(j < k && nums[k] == nums[k - 1]) k--;

                    j++;
                    k--;
                } else if(sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return result;
    }
}

//nums = [-1,0,1,2,-1,-4] -> -4,-1,-1,0,1,2
//[-1,0,1], [-1,2,-1], 