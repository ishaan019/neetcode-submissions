class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int ROWS = grid.length;
        int COLS = grid[0].length;

        int freshFruits = 0;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == 1) {
                    freshFruits++;
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        // Multi source BFS
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == 2) {
                    queue.offer(new int[] {r, c});
                    visited.add(r + "," + c);
                }
            }
        }

        int time = 0;
        while (!queue.isEmpty() && freshFruits > 0) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int[] arr = queue.poll();
                int r = arr[0];
                int c = arr[1];

                for(int[] dir : directions) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if(nr >= 0 && nc >= 0 && nr < ROWS && nc < COLS 
                       && !visited.contains(nr + "," + nc) && grid[nr][nc] == 1) {
                        queue.offer(new int[] {nr, nc});
                        visited.add(nr + "," + nc);
                        freshFruits--;
                    }
                }
            }
            time++;
        }
        return freshFruits == 0 ? time : -1;
    }
}
