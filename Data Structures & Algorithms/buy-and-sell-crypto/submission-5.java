class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 1) {
            return 0;
        }

        int buy = 0;
        int sell = 1;

        int maxProfit = 0;

        while(sell < prices.length) {
            int currProfit = prices[sell] - prices[buy];
            maxProfit = Math.max(maxProfit, currProfit);

            if(prices[sell] < prices[buy]) {
                buy = sell;
            }
            sell++;
        }

        return maxProfit;       
    }
}
