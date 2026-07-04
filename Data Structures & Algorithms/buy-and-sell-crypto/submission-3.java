class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int l = 0;
        int r = 1;
        int maxProfit = 0;

        while(r < n) {
            if(prices[l] < prices[r]) {
                int profit = prices[r] - prices[l];
                maxProfit = Math.max(maxProfit, profit);
            } else {
                l = r;
            }
            r++;
        }
        return maxProfit; 
    }
}
