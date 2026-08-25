class Solution {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {

        List<String> curr = new ArrayList<>();
        dfs(0, s, curr);

        return res;        
    }

    void dfs(int i, String s, List<String> curr) {
        //base case
        if(i == s.length()) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int j = i; j < s.length(); j++) {//1
            String str = s.substring(i, j + 1);//0,1
            if(isPalin(str)) {
                curr.add(str);
                dfs(j + 1, s, curr);
                curr.remove(curr.size() - 1);
            }
        }
    }

    boolean isPalin(String s) {
        int l = 0;
        int r = s.length() - 1;

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
