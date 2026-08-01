class Solution {
    public boolean checkValidString(String s) {
        int open = 0;

        // Make dp or hashset
        Map<String, Boolean> dp = new HashMap<>();

        return dfs(s, open, 0, dp);
    }

    boolean dfs(String s, int openParanthesis, int i, Map<String, Boolean> dp) {
        if (openParanthesis < 0) {
            return false;
        }

        if (i == s.length()) {
            return openParanthesis == 0;
        }

        String key = "i" + i + "_" + openParanthesis;

        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        char ch = s.charAt(i);
        boolean res = false;
        if (ch == '(') {
            res = dfs(s, openParanthesis + 1, i + 1, dp);
        } else if (ch == '*') {
            // 3 calls
            res = dfs(s, openParanthesis - 1, i + 1, dp) || dfs(s, openParanthesis, i + 1, dp)
                || dfs(s, openParanthesis + 1, i + 1, dp);

        } else {
            res = dfs(s, openParanthesis - 1, i + 1, dp);
        }
        dp.put(key, res);
        return res;
    }
}
