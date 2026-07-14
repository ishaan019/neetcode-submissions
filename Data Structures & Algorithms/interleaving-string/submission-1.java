class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        HashMap<String, Boolean> dp = new HashMap<>();
        return dfs(0, 0, s1, s2, s3, dp);
    }

    boolean dfs(int i, int j, String s1, String s2, String s3, HashMap<String, Boolean> dp) {
        if((i + j) == s3.length()) {
            return i == s1.length() && j == s2.length();
        }

        String key = "i=" + i + "j=" + j;
        
        if(dp.containsKey(key)) {
            return dp.get(key);
        }

        boolean ans = false;
        if(i < s1.length() && s1.charAt(i) == s3.charAt(i + j)) {
            if(dfs(i + 1, j, s1, s2, s3, dp)) {
                ans = true;
            }
        }

        if(j < s2.length() && s2.charAt(j) == s3.charAt(i + j)) {
            if(dfs(i, j + 1, s1, s2, s3, dp)) {
                ans = true;
            }
        }

        dp.put(key, ans);
        return dp.get(key);
    }
}
