class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();//num, Index
        int[] ans = new int[2];

       
        for(int i = 0; i < n; i++) {
            if(map.containsKey(target - nums[i])) {
                ans[0] = map.get(target - nums[i]);
                ans[1] = i;
            } else {
                map.put(nums[i], i);//(3,1), 
            }
        }

        return ans;
        
    }
}
