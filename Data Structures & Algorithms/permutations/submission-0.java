class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> perm = new ArrayList<>();

        backtrack(perm, nums, new boolean[nums.length], res);
        return res;
    }

    public void backtrack(List<Integer> perm, int[] nums, boolean[] pick, List<List<Integer>> res) {
        if (perm.size() == nums.length) {
            res.add(new ArrayList<>(perm));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!pick[i]) {
                perm.add(nums[i]);
                pick[i] = true;
                backtrack(perm, nums, pick, res);
                perm.remove(perm.size() - 1);
                pick[i] = false;
            }
        }
    }
}
