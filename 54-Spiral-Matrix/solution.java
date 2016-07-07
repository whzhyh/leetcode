public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return ans;

        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int colStart = 0;
        int colEnd = matrix[0].length - 1;
        
        
        while(rowStart <= rowEnd && colStart <= colEnd) {
            for(int j = colStart; j <= colEnd; j++) {
                ans.add(matrix[rowStart][j]);    
            }
            rowStart++;
            
            for(int i = rowStart; i <= rowEnd; i++) {
                ans.add(matrix[i][colEnd]);    
            }
            colEnd--;
            
            if(rowStart <= rowEnd) {
                for(int j = colEnd; j >= colStart; j--) {
                    ans.add(matrix[rowEnd][j]);    
                }
            }
            rowEnd--;
            
            if(colStart <= colEnd) {
                for(int i = rowEnd; i >= rowStart; i--) {
                    ans.add(matrix[i][colStart]);    
                }
            }
            colStart++;    
            
        } 
        return ans;
    }
}