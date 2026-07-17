class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;

        int targetRow = -1;

        int top = 0;
        int bottom = ROWS - 1;

        while (top <= bottom) {
            int row = (top + bottom) / 2;

            if (target > matrix[row][COLS - 1]) {
                top = row + 1;
            } else if (target < matrix[row][0]) {
                bottom = row - 1;
            } else {
                targetRow = row;
                break;
            }
        }

        if (targetRow == -1) {
            return false;
        }

        int low = 0;
        int high = COLS - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (target > matrix[targetRow][mid]) {
                low = mid + 1;
            } else if (target < matrix[targetRow][mid]) {
                high = mid - 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
