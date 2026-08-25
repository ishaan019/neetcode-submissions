class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> curr = new ArrayList<>();
        boolean[] pick = new boolean[nums.length];

        dfs(nums, curr, pick);

        return res;
    }

    void dfs(int[] nums, List<Integer> curr, boolean[] pick) {
        if (curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
        }

        for (int k = 0; k < nums.length; k++) {
            if (pick[k] == false) {
                int val = nums[k];
                curr.add(nums[k]); // 1
                pick[k] = true;
                dfs(nums, curr, pick);
                curr.remove(curr.size() - 1);
                pick[k] = false;
            }
        }
    }
}
