class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.equals(text2)) {
            return text1.length();
        }

        int[][] dp = new int[text1.length()][text2.length()];
        for(int[] d : dp) {
            Arrays.fill(d, -1);
        }
        

        return dfs(0, 0, text1, text2, dp);
    }

    int dfs(int i, int j, String text1, String text2, int[][] dp) {
        if (i == text1.length() || j == text2.length()) {
            return 0;
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        int ans = 0;

        if (text1.charAt(i) == text2.charAt(j)) {
            ans = Math.max(ans, 1 + dfs(i + 1, j + 1, text1, text2, dp));
        } else {
            ans = Math.max(ans, dfs(i + 1, j, text1, text2, dp));

            ans = Math.max(ans, dfs(i, j + 1, text1, text2, dp));
        }

        dp[i][j] = ans;

        return ans;
    }
}
