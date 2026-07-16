class Solution {
    int operations = Integer.MAX_VALUE;;
    public int minDistance(String word1, String word2) {

        int[][] dp = new int[word1.length()][word2.length()];

        for(int[] i : dp) {
            Arrays.fill(i, - 1);
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

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        if(word1.charAt(i) == word2.charAt(j)) {
            return dfs(i + 1, j + 1, word1, word2, dp);
        }

        int res = Math.min(dfs(i, j + 1, word1, word2, dp), dfs(i + 1, j, word1, word2, dp));
        res = Math.min(res, dfs(i + 1, j + 1, word1, word2, dp));
        
        dp[i][j] = res + 1;

        return res + 1;
    }
}
