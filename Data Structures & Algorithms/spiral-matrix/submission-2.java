class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length; 

        int minRow = 0;
        int maxRow = ROWS - 1;

        int minCol = 0;
        int maxCol = COLS - 1;

        int totalElements = ROWS * COLS;
        // int count = 0;

        List<Integer> res = new ArrayList<>();

        while(res.size() < totalElements) {

            //top wall
            for(int j = minCol; j <= maxCol && res.size() < totalElements; j++) {
                int element = matrix[minRow][j];
                res.add(element);//123
            }
            minRow++;

            //right wall
            for(int i = minRow; i <= maxRow && res.size() < totalElements; i++) {
                int element = matrix[i][maxCol];
                res.add(element);//12369
            }
            maxCol--;


            //bottom wall
            for(int j = maxCol; j >= minCol && res.size() < totalElements; j--) {
                int element = matrix[maxRow][j];
                res.add(element);//1236987
            }
            maxRow--;

            //left wall
            for(int i = maxRow; i >= minRow && res.size() < totalElements; i--) {
                int element = matrix[i][minCol];
                res.add(element);//12369874
            }
            minCol++;
        }
        return res;
    }
}