class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {

        List<Integer> curr = new ArrayList<>();
        dfs(0, nums, curr);

        return res; 
    }

    void dfs(int i, int[] nums, List<Integer> curr) {

        if(i == nums.length) {
            res.add(new ArrayList<>(curr));//O(n)
            return;
        }

        int val = nums[i];

        //take it
        curr.add(val);
        dfs(i + 1, nums, curr);
        curr.remove(curr.size() - 1);

        //skip it
        dfs(i + 1, nums, curr);
    } 
}
