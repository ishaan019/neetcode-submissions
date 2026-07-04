class Solution {
    public int numDecodings(String s) { // 12
        int n = s.length(); // 2
        int[] dp = new int[n + 1]; //[0,1,_]
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i <= n; i++) {
            int oneDigit = Integer.valueOf(s.substring(i - 1, i));//2
            int twoDigit = Integer.valueOf(s.substring(i - 2, i));//12

            if (oneDigit >= 1) {
                dp[i] += dp[i - 1];
            }

            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }
}
