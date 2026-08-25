class Solution {
    List<List<String>> res = new ArrayList<>();
    Set<Integer> cols = new HashSet<>();
    Set<Integer> posDia = new HashSet<>();
    Set<Integer> negDia = new HashSet<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] b : board) {
            Arrays.fill(b, '.');
        }

        dfs(0, n, board);

        return res;
    }

    void dfs(int r, int n, char[][] board) {
        // base case
        // append ans in res

        if (cols.size() == n && posDia.size() == n && negDia.size() == n) {
            // [.Q..]
            // [...Q]
            // [Q...]
            // [..Q.]

            List<String> curr = new ArrayList<>();

            for (char[] b : board) {
                curr.add(new String(b)); //[".Q..", ""]
            }

            res.add(curr);
            return;
        }

        for (int c = 0; c < n; c++) {
            if (cols.contains(c) || posDia.contains(r + c) || negDia.contains(r - c)) {
                continue;
            }

            cols.add(c);
            posDia.add(r + c);
            negDia.add(r - c);
            board[r][c] = 'Q';

            dfs(r + 1, n, board);

            cols.remove(c);
            posDia.remove(r + c);
            negDia.remove(r - c);
            board[r][c] = '.';
        }
    }
}
