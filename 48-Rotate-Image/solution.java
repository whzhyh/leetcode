public class Solution {
    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return;
        int n = matrix.length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; i + j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][n - i - 1];
                matrix[n - j - 1][n - i - 1] = tmp;
            }
        }
        
        for(int i = 0; i < n / 2; i++) {
            for(int j = 0; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = tmp;
            }
        }
    }
}