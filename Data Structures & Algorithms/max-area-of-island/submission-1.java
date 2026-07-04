class Solution {
    public int maxAreaOfIsland(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        int max = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1 && visited[i][j] == false) {
                    int count = dfs(i, j, grid, visited, m, n, dirs);
                    max = Math.max(max, count);
                }
            }
        }

        return max;
    }

    private int dfs(int row, int col, int[][] grid, boolean[][] visited, int m, int n, int[][] dirs) {
        visited[row][col] = true;
        int count = 1;

        for(int[] d : dirs) {
            int nr = row + d[0];
            int nc = col + d[1];

            if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1 && visited[nr][nc] == false) {
                count += dfs(nr, nc, grid, visited, m, n, dirs);
            }
        }

        return count;
    }
}
