public class Solution {
    public int[][] generateMatrix(int n) {
        if(n <= 0)
            return new int[0][0];
        int[][] ans = new int[n][n];
        int rowStart = 0, rowEnd = n - 1;
        int colStart = 0, colEnd = n - 1;
        
        int num = 1;
        while(rowStart <= rowEnd && colStart <= colEnd) {
            for(int j = colStart; j <= colEnd; j++) {
                ans[rowStart][j] = num++;
            }
            rowStart++;
            
            for(int i = rowStart; i <= rowEnd; i++) {
                ans[i][colEnd] = num++;
            }
            colEnd--;
            
            if(rowStart <= rowEnd) {
                for(int j = colEnd; j >= colStart; j--) {
                    ans[rowEnd][j] = num++;
                }
            }
            rowEnd--;
            
            if(colStart <= colEnd) {
                for(int i = rowEnd; i >= rowStart; i--) {
                    ans[i][colStart] = num++;
                }
            }
            colStart++;
        }
        return ans;
    }
}