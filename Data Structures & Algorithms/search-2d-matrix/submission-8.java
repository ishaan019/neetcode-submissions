class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;

        int totalElements = ROWS * COLS;

        int l = 0;
        int h = totalElements - 1;

        while (l <= h) {
            int m = (l + h) / 2;

            int r = m / COLS;
            int c = m % COLS;

            if (matrix[r][c] == target) {
                return true;
            } else if (target < matrix[r][c]) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }

        return false;
    }
}
