class Solution {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        /*
        [1,2,3],
        [4,5,6],
        [7,8,9]
        */
        reverse(matrix, m);
        for(int[] i : matrix) {
            System.out.println(Arrays.toString(i));
        }

        /*
        [7,8,9],
        [4,5,6],
        [1,2,3]
        */

        // transpose in upper side from diagonal

        for(int i = 0; i < m; i++) {
            for(int j = i; j < n; j++) {
                //swap the [i][j] with [j][i]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public void reverse(int[][] matrix, int n) {
        for(int i = 0; i < n / 2; i++) {
            int[] temp = matrix[i];
            matrix[i] = matrix[n - 1 - i];
            matrix[n - 1 - i] = temp;
        }
    }
}
