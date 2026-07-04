class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int[] ans = new int[2];

        //two pointer approach

        int l = 0;
        int r = n - 1;

        while(l < r) {
            int sum = numbers[l] + numbers[r];
            if(sum == target) {
                ans[0] = l + 1;
                ans[1] = r + 1;
                break;
            } else if (sum < target) {
                l++;
            } else {
                r--;
            }
        } 
        return ans;    
    }
}
