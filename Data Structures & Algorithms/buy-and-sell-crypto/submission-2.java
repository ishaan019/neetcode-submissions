class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int max = 0;
        int prev = 0;

        for(int i = 1; i < n; i++) {
            prev = Math.max((prev + (prices[i] - prices[i - 1])), 0);
            max = Math.max(max, prev);
        }

        return max;
    }
}
