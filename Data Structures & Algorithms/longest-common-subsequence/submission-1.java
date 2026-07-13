class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int ROWS = text2.length();
        int COLS = text1.length();

        int[][] dp = new int[ROWS + 1][COLS + 1];

        for(int i = 1; i <= ROWS; i++) {
            for(int j = 1; j <= COLS; j++) {
                if(text2.charAt(i - 1) == text1.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i-1][j]);
                }
            }
        }
        return dp[ROWS][COLS];
    }
}
