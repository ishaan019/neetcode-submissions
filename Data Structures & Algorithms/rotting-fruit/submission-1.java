class Solution {
    public int orangesRotting(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int freshOranges = 0;

        int minutes = 0;

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[] {i, j});
                }
                if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        if (freshOranges == 0) {
            return 0;
        }

        if (q.isEmpty()) {
            return -1;
        }

        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (!q.isEmpty() && freshOranges > 0) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] top = q.poll();
                int r = top[0];
                int c = top[1];

                for (int[] dir : dirs) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if (nr < 0 || nr >= ROWS || nc < 0 || nc >= COLS || grid[nr][nc] != 1) {
                        continue;
                    }

                    grid[nr][nc] = 2;
                    freshOranges--; // 2
                    q.add(new int[] {nr, nc});
                }
            }
            minutes++;
        }
        return freshOranges == 0 ? minutes : -1;
    }
}
