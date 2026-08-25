class Solution {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();

        dfs(0, 0, n, sb);

        return res;
    }

    void dfs(int openCount, int closeCount, int n, StringBuilder sb) {
        if (openCount == n && closeCount == n) {
            res.add(new String(sb.toString()));
            return;
        }
        //2<3
        if (openCount < n) {
            // Opening laado
            sb.append("(");
            dfs(openCount + 1, closeCount, n, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        //3<3//(()())
        if (closeCount < openCount) {
            // close laado
            sb.append(")");
            dfs(openCount, closeCount + 1, n, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
