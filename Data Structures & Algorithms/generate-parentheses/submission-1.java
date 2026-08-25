class Solution {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {

        StringBuilder sb = new StringBuilder();
        dfs(0,0, n, sb);

        return res;
        
    }

    //openingCount < n, openingCount la
    //and agar closingCount < openingCount, taan closing la

    void dfs(int oCount, int cCount, int n, StringBuilder sb) {
        if(oCount == n && cCount == n) {
            res.add(sb.toString());
            return;
        }

        if(oCount < n) {
            sb.append("(");
            dfs(oCount + 1, cCount, n, sb);
            sb.deleteCharAt(sb.length() - 1);
        }


        if(cCount < oCount) {
            sb.append(")");
            dfs(oCount, cCount + 1, n, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
