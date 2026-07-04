class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        int maxDictWordLength = Integer.MIN_VALUE;//4
        for(String str : wordDict) {
            maxDictWordLength = Math.max(maxDictWordLength, str.length());//4
        }

        for(int i = 1; i <= n; i++) {
            for(int j = i; j > i - maxDictWordLength && j >= 1; j--) {
                String subString = s.substring(j - 1, i);
                if(wordDict.contains(subString)) {
                    if(dp[j - 1] == true) {
                        dp[i] = true;
                    } else {
                        continue;
                    }
                }
            }
        }

        return dp[n];
    }
}
