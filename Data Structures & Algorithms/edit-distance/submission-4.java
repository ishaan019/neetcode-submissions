class Solution {
    public int minDistance(String word1, String word2) {

        int[][] dp = new int[word1.length()][word2.length()];

        for(int[] i : dp) {
            Arrays.fill(i, -1);
        }

        return dfs(0, 0, word1, word2, dp);
        
    }

    int dfs(int i, int j, String word1, String word2, int[][] dp) {
        if(i == word1.length()) {
            return word2.length() - j;
        }

        if(j == word2.length()) {
            return word1.length() - i;
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        int res = 0;
        if(word1.charAt(i) == word2.charAt(j)) {
            return dfs(i + 1, j + 1, word1, word2, dp);
        } else {
            res = Math.min(dfs(i, j + 1, word1, word2, dp), dfs(i + 1, j, word1, word2, dp));
            res = Math.min(res, dfs(i + 1, j + 1, word1, word2, dp));
        }

        dp[i][j] = 1 + res;

        return 1 + res;
    }
}
