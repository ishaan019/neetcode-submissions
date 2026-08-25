class Solution {
    public int numIslands(char[][] grid) {
        // iterate over all indices and if i found index as 1, i pull run dfs
        // what dfs will do?
        // dfs will change the index from 1 to 2 saying it is visited
        // if it is out of bound or aready visited, go back

        int ROWS = grid.length; // 4
        int COLS = grid[0].length; // 6

        int count = 0; // 1

        for (int r = 0; r < ROWS; r++) { // 1
            for (int c = 0; c < COLS; c++) { // 5
                if (grid[r][c] == '1') {
                    dfs(r, c, grid);
                    count++;
                }
            }
        }

        return count;
    }

    void dfs(int r, int c, char[][] grid) { // 0,1

        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] != '1') {
            return;
        }

        grid[r][c] = '2';

        // directions
        // left
        dfs(r, c - 1, grid);
        // right
        dfs(r, c + 1, grid);
        // up
        dfs(r - 1, c, grid);
        // down
        dfs(r + 1, c, grid);
    }
}
