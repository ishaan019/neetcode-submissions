class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        
        List<String> curr = new ArrayList<>();

        dfs(0, s, curr);
        
        return res;
    }

    void dfs(int i, String s, List<String> curr) {
        if(i >= s.length()) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int j = i; j < s.length(); j++) {
            if(isPali(s, i, j)) {
                curr.add(s.substring(i, j + 1));
                dfs(j + 1, s, curr);
                curr.remove(curr.size() - 1);
            }
        }
    }

    boolean isPali(String s, int l, int r) {
        while(l < r) {
            if(s.charAt(l) != s.charAt(r)) {
                return false;
            }

            l++;
            r--;
        }
        return true;
    }
}
