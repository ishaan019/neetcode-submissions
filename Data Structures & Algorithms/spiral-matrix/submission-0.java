class Solution {
    public List<Integer> spiralOrder(int[][] arr) {
        int minRow = 0;
        int minCol = 0;
        int maxRow = arr.length - 1;
        int maxCol = arr[0].length - 1;

        int counter = 0;
        int totalElements = arr.length * arr[0].length;

        List<Integer> ans = new ArrayList<>();

        while (counter < totalElements) {

            //Top Wall
            for (int j = minCol; j <= maxCol && counter < totalElements; j++) {
                ans.add(arr[minRow][j]);
                counter++;
            }
            minRow++;

            //Right Wall
            for (int i = minRow; i <= maxRow && counter < totalElements; i++) {
                ans.add(arr[i][maxCol]);
                counter++;
            }

            maxCol--;

            //Bottom Wall
            for (int j = maxCol; j >= minCol && counter < totalElements; j--) {
                ans.add(arr[maxRow][j]);
                counter++;
            }

            maxRow--;


            //Left Wall
            for (int i = maxRow; i >= minRow && counter < totalElements; i--) {
                ans.add(arr[i][minCol]);
                counter++;
            }

            minCol++;
        }

        return ans;
    }
}