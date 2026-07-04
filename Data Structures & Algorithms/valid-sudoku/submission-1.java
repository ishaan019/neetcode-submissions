class Solution {
    public boolean isValidSudoku(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<String, Set<Character>> squares = new HashMap<>();

        for(int r = 0; r < m; r++) {
            for(int c = 0; c < n; c++) {

                char ch = board[r][c];
                
                if(ch == '.') {
                    continue;
                }

                String squareKey = (r / 3) + "," + (c / 3);

                if(rows.computeIfAbsent(r, k -> new HashSet<>()).contains(ch) ||
                   cols.computeIfAbsent(c, k -> new HashSet<>()).contains(ch) ||
                   squares.computeIfAbsent(squareKey, k -> new HashSet<>()).contains(ch)) {
                    return false;
                }

                rows.get(r).add(ch);
                cols.get(c).add(ch);
                squares.get(squareKey).add(ch);
            }
        }
        return true;
    }
}
