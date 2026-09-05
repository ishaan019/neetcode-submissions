class Solution {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();//value, index

        for(int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];//4
            if(map.containsKey(diff)) {
                return new int[] {map.get(diff), i};
            } else {
                map.put(nums[i], i);
            }
        }

        return new int[] {0, 0};
    }
}
