class Solution {
    public boolean canJump(int[] nums) {
        int N = nums.length;

        int goal = N - 1;

        for(int i = N - 2; i >= 0; i--) {
            if(i + nums[i] >= goal) {
                goal = i;
            }
        }

        return goal == 0;
    }
}
