class Solution {

    List<List<String>> res = new ArrayList<>();

    Set<Integer> cols = new HashSet<>();
    Set<Integer> positiveDia = new HashSet<>();
    Set<Integer> negativeDia = new HashSet<>();
    public List<List<String>> solveNQueens(int n) {

        char[][] board = new char[n][n];
        for(char[] arr : board) {
            Arrays.fill(arr, '.');
        }

        dfs(0, n, board);
        return res;
    }

    void dfs(int r, int n, char[][] board) {
        if(r == n) {
            List<String> copy = new ArrayList<>();
            for(char[] row : board) {
                copy.add(new String(row));
            }

            res.add(copy);
            return;
        }

        for(int c = 0; c < n; c++) {
            if(cols.contains(c) || positiveDia.contains(r + c) || negativeDia.contains(r - c)) {
                continue;
            }

            cols.add(c);
            positiveDia.add(r + c);
            negativeDia.add(r - c);
            board[r][c] = 'Q';

            dfs(r + 1, n, board);

            cols.remove(c);
            positiveDia.remove(r + c);
            negativeDia.remove(r - c);
            board[r][c] = '.';
        }
    }
}
