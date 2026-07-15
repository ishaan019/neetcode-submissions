class Solution {
    public int numDistinct(String s, String t) {
        // Map<String, Integer> dp = new HashMap<>();
        int[][] dp = new int[s.length()][t.length()];
        for(int[] i : dp) {
            Arrays.fill(i, -1);
        }
        
        return dfs(0, 0, s, t, dp);
    }

    int dfs(int i, int j, String s, String t, int[][] dp) {
        if (j == t.length()) {
            return 1;
        }
        if (i == s.length()) {
            return 0;
        }

        // String key = "i=" + i + "j=" + j;

        // if (dp.containsKey(key)) {
        //     return dp.get(key);
        // }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int count = 0;
        if (s.charAt(i) == t.charAt(j)) {
            count += dfs(i + 1, j + 1, s, t, dp);
        }

        count += dfs(i + 1, j, s, t, dp);

        // dp.put(key, count);
        dp[i][j] = count;

        return count;
    }
}
