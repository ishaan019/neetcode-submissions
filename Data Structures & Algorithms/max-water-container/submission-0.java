class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;

        int l = 0;
        int r = n - 1;

        int ans = 0;

        while(l < r) {
            int min = Math.min(heights[l], heights[r]);
            ans = Math.max(ans, min * (r - l));

            if(heights[l] < heights[r]) {
                l++;
            } else {
                r--;
            }
        }

        return ans;
        
    }
}
// 0,1,2,3,4,5,6,7
//[1,7,2,5,4,7,3,6]
