class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (grid[i][j] == 0) {
                    queue.add(new int[] {i, j});
                }
            }
        }

        if (queue.size() == 0) {
            return;
        }

        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (queue.isEmpty() == false) {
            int[] top = queue.poll(); //(0,2)
            int r = top[0]; // 0
            int c = top[1]; // 2
            for (int[] dir : dirs) {
                int nr = r + dir[0]; // 0
                int nc = c + dir[1]; // 3
                if (nr < 0 || nr >= ROWS || nc < 0 || nc >= COLS || grid[nr][nc] != 2147483647) {
                    continue;
                }

                queue.add(new int[] {nr, nc});
                grid[nr][nc] = grid[r][c] + 1;
            }
        }
    }
}
