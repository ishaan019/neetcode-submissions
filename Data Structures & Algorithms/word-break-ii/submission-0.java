class Solution {
    List<String> res = new ArrayList<>();

    public List<String> wordBreak(String s, List<String> wordDict) {

        List<String> curr = new ArrayList<>();
        dfs(0, s, wordDict, curr);
        return res;
    }

    void dfs(int i, String s, List<String> wordDict, List<String> curr) {
        if(i == s.length()) {
            StringBuilder sb = new StringBuilder();
            for(String str : curr) {
                sb.append(str).append(" ");
            }
            sb.deleteCharAt(sb.length() - 1);

            res.add(sb.toString());
        }


        for(String w : wordDict) {
            if(i + w.length() <= s.length() && s.substring(i, i + w.length()).equals(w)) {
                curr.add(w);
                dfs(i + w.length(), s, wordDict, curr);
                curr.remove(curr.size() - 1);
            }
        }
    }
}