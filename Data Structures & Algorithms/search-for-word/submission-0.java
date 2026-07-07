class Solution {
    

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for(int r = 0; r < m; r++) {
            for(int c = 0; c < n; c++) {
                if(dfs(board, word, r, c, 0, m, n)) {
                    return true;
                }
            }
        }

        return false;
    }

    boolean dfs(char[][] board, String word, int r, int c, int i, int m, int n) {

        if(i == word.length()) {
            return true;
        }
        if(r < 0 || r >= m || c < 0 || c >= n || board[r][c] != word.charAt(i) || board[r][c] == '#') {
            return false;
        }

        board[r][c] = '#';

        boolean res = dfs(board, word, r + 1, c, i + 1, m, n) ||
                      dfs(board, word, r - 1, c, i + 1, m, n) ||
                      dfs(board, word, r, c + 1, i + 1, m, n) ||
                      dfs(board, word, r, c - 1, i + 1, m, n);

        board[r][c] = word.charAt(i);

        return res;
    }


}
