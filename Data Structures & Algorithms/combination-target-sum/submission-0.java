class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {

        List<List<Integer>> res = new ArrayList<>();

        List<Integer> ans = new ArrayList<>();

        dfs(nums, target, ans, res, 0);

        return res;
        
    }

    public void dfs(int[] nums, int target, List<Integer> ans, List<List<Integer>> res,int i) {
        if(target == 0) {
            res.add(new ArrayList(ans));
            return;
        }
        if(target < 0 || i >= nums.length) {
            return;
        }

        ans.add(nums[i]);
        dfs(nums, target - nums[i], ans, res, i);
        ans.remove(ans.size() - 1);
        dfs(nums, target, ans, res, i + 1);
    }
}
