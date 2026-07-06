class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        Arrays.sort(nums);

        dfs(nums, target, curr, res, 0);
        return res;
    }

    void dfs(int[] nums, int target, List<Integer> curr, List<List<Integer>> res, int i) {
        if(target == 0) {
            res.add(new ArrayList(curr));
            return;
        }
        if(target < 0 || i >= nums.length) {
            return;
        }

        //choice 1 : include
        curr.add(nums[i]);
        dfs(nums, target - nums[i], curr, res, i + 1);
        curr.remove(curr.size() - 1);

        //choice 2 : exclude
        while(i + 1 < nums.length && nums[i] == nums[i + 1]) {
           i++;
        }
        dfs(nums, target, curr, res, i + 1);
    }
}
