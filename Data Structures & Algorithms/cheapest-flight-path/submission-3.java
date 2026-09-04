class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;

        for(int i = 0; i <= k; i++) {
            int[] temp = Arrays.copyOf(prices, n);

            for(int[] f : flights) {
                int u = f[0];
                int v = f[1];
                int w = f[2];

                if(prices[u] == Integer.MAX_VALUE) {
                    continue;
                }

                if(prices[u] + w < temp[v]) {
                    temp[v] = prices[u] + w;
                }
            }

            prices = temp;
        }

        if(prices[dst] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return prices[dst];
        }
    }
}
