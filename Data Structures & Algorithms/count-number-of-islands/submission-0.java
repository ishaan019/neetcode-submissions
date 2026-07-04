class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        int count = 0;

        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1' && visited[i][j] == false) {
                    dfs(i,j, grid, visited, dirs, m, n);
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(int row, int col, char[][] grid, boolean[][] visited, int[][] dirs, int m, int n) {
        
        visited[row][col] = true;

        for(int[] d : dirs) {
            int nr = row + d[0];
            int nc = col + d[1];

            if(nr >= 0 && nr < m && nc >= 0 && nc < n && visited[nr][nc] == false && grid[nr][nc] == '1') {
                dfs(nr, nc, grid, visited, dirs, m, n);
            }
        }
    }
}
