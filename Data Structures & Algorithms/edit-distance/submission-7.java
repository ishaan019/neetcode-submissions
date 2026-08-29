class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        for(int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return dfs(0, 0, word1, word2, dp);
    }

    int dfs(int i, int j, String word1, String word2, int[][] dp) {
        if(j == word2.length()) {
            return word1.length() - i;
        }

        if(i == word1.length()) {
            return word2.length() - j;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }
       
        int ans = Integer.MAX_VALUE;
    
        if (word1.charAt(i) == word2.charAt(j)) {
            ans = Math.min(ans, dfs(i + 1, j + 1, word1, word2, dp));
        } else {
            // insert
            ans = Math.min(ans, 1 + dfs(i, j + 1, word1, word2, dp));

            // delete
            ans = Math.min(ans, 1 + dfs(i + 1, j, word1, word2, dp));

            // replace
            ans = Math.min(ans, 1 + dfs(i + 1, j + 1, word1, word2, dp));
        }

        dp[i][j] = ans;

        return ans;
    }
}
