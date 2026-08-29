class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) {
            return false;
        }

        Boolean[][] dp = new Boolean[s1.length() + 1][s2.length() + 1];
        return dfs(0, 0, 0, s1, s2, s3, dp);
    }

    boolean dfs(int i, int j, int z, String s1, String s2, String s3, Boolean[][] dp) {
        if (z == s3.length()) {
            return (i == s1.length()) && (j == s2.length());
        }

        // if (i + j != z) {
        //     return false;
        // }

        if(dp[i][j] != null) {
            return dp[i][j];
        }

        boolean isPossible = false;

        if (i <  s1.length() && z < s3.length() && s1.charAt(i) == s3.charAt(z)) {
            if (dfs(i + 1, j, z + 1, s1, s2, s3, dp)) {
                isPossible = true;
            }
        } 
        
        if (!isPossible && j <  s2.length() && z < s3.length() && s2.charAt(j) == s3.charAt(z)) {
            if (dfs(i, j + 1, z + 1, s1, s2, s3, dp)) {
                isPossible = true;
            }
        }

        dp[i][j] = isPossible;
        return isPossible;
    }
}
