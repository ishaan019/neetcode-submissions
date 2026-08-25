class Solution {
    public boolean exist(char[][] board, String word) {
        int ROWS = board.length;
        int COLS = board[0].length;

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(i, j, 0, board, word.toCharArray())) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    boolean dfs(int i, int j, int index, char[][] board, char[] word) { // 0,0,0
        if (index == word.length) {
            return true;
        }

        if (i < 0 || i == board.length || j < 0 || j == board[0].length || board[i][j] == '#') {
            return false;
        }

        if (board[i][j] != word[index]) {
            return false;
        }

        char ch = word[index];
        board[i][j] = '#';

        boolean res = dfs(i + 1, j, index + 1, board, word) || dfs(i - 1, j, index + 1, board, word)
            || dfs(i, j + 1, index + 1, board, word) || dfs(i, j - 1, index + 1, board, word);

        board[i][j] = ch;

        return res;
    }
}
