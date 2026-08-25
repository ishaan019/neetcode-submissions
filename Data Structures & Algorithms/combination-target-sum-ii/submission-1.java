class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);

        List<Integer> curr = new ArrayList<>();
        dfs(0, nums, target, curr);

        return res;
    }

    void dfs(int i, int[] nums, int target, List<Integer> curr) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }

        if (target < 0 || i >= nums.length) {
            return;
        }

        int val = nums[i];
        // take it
        curr.add(val);
        dfs(i + 1, nums, target - val, curr);
        curr.remove(curr.size() - 1);

        // skip it
        while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
            i++;
        }
        dfs(i + 1, nums, target, curr);
    }
}
