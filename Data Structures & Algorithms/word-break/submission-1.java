class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        Map<Integer, Boolean> dp = new HashMap<>();

        return dfs(0, s, wordDict, dp);
    }

    boolean dfs(int i, String s, List<String> wordDict, Map<Integer, Boolean> dp) {
        if(i == s.length()) {
            return true;
        }

        if(dp.get(i) != null) {
            return dp.get(i);
        }


        for(String w : wordDict) {
            if(i + w.length() <= s.length() && s.substring(i, i + w.length()).equals(w)) {
                if(dfs(i + w.length(), s, wordDict, dp)) {
                    dp.put(i, true);
                    return true;
                }
            }
        }
        dp.put(i, false);
        return false;
    }
}
