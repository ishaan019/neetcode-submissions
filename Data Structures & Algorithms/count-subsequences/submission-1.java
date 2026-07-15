class Solution {
    public int numDistinct(String s, String t) {
        Map<String, Integer> dp = new HashMap<>();
        return dfs(0, 0, s, t, dp);
    }

    int dfs(int i, int j, String s, String t, Map<String, Integer> dp) {
        if (j == t.length()) {
            return 1;
        }
        if (i == s.length()) {
            return 0;
        }

        String key = "i=" + i + "j=" + j;

        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        int count = 0;
        if (s.charAt(i) == t.charAt(j)) {
            count += dfs(i + 1, j + 1, s, t, dp);
        }

        count += dfs(i + 1, j, s, t, dp);

        dp.put(key, count);

        return count;
    }
}
