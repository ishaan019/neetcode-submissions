class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;

        int targetRow = -1;

        for (int i = 0; i < ROWS; i++) {
            if(target == matrix[i][COLS - 1]) {
                return true;
            }
            if (target < matrix[i][COLS - 1]) {
                targetRow = i;
                break;
            }
        }

        if (targetRow == -1) {
            return false;
        }

        int low = 0;
        int high = COLS - 1;

        while(low <= high) {
            int mid = (low + high) / 2;

            if(target > matrix[targetRow][mid]) {
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
