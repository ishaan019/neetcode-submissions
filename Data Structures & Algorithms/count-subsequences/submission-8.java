class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()][t.length()];

        for(int[] d : dp) {
            Arrays.fill(d, -1);
        }

        return dfs(0, 0, s, t, dp);
    }

    int dfs(int i, int j, String s, String t, int[][] dp) {

        if(j == t.length()) {
            return 1;
        }

        if(i == s.length()) {
            return 0;
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        int ans = 0;

        //take it
        if(s.charAt(i) == t.charAt(j)) {
            ans += dfs(i + 1, j + 1, s, t, dp);
        }

        //skip it
        ans += dfs(i + 1, j, s, t, dp);

        dp[i][j] = ans;

        return ans;
    }


}
