class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        int ROWS = board.length;
        int COLS = board[0].length;

        for(String word : words) {
            boolean flag = false;
            for(int r = 0; r < ROWS && flag == false; r++) {
                for(int c = 0; c < COLS; c++) {
                    if(board[r][c] != word.charAt(0)) {
                        continue;
                    }
                    if(backTrack(board, word, r, c, 0)) {
                        ans.add(word);
                        flag = true;
                        break;
                    }
                }
            }
        }

        return ans;
    }


    boolean backTrack(char[][] board, String word, int i, int j, int idx) {
        if(idx >= word.length()) {
            return true;
        }

        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '#' || board[i][j] != word.charAt(idx)) {
            return false;
        }

        board[i][j] = '#';

        boolean ans = backTrack(board, word, i - 1, j, idx + 1) ||
        backTrack(board, word, i + 1, j, idx + 1) ||
        backTrack(board, word, i, j - 1, idx + 1) ||
        backTrack(board, word, i, j + 1, idx + 1);

        board[i][j] = word.charAt(idx);

        return ans;
    }
}
