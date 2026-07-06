class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> curr = new ArrayList<>();

        Arrays.sort(nums);
        
        dfs(nums, 0, curr, res);

        return res;

    }

    void dfs(int[] nums, int i, List<Integer> curr, List<List<Integer>> res) {
        if(i == nums.length) {
            res.add(new ArrayList(curr));
            return;
        }

        curr.add(nums[i]);
        dfs(nums, i + 1, curr, res);
        curr.remove(curr.size() - 1);

        while(i + 1 < nums.length && nums[i] == nums[i+1]) {
            i++;
        }
        dfs(nums, i + 1, curr, res);
    }
}
