public class Solution {
    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return;
        int n = matrix.length;
        
        // 1. flip the matrix horizontally.
        for(int i = 0; i < n / 2; i++) {
            for(int j = 0; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = tmp;
            }
        }
        
        // 2. flip the matrix by y = x;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
}