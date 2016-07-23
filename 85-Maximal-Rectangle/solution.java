public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);
        int[] height = new int[n];
        int ans = 0;
        
        for(int i = 0; i < m; i++) {
            int cur_left = 0, cur_right = n;
            for(int j = 0; j < n; j++) {
                height[j] = matrix[i][j] == '1' ? height[j] + 1 : 0;
            }
            
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == '1')
                    left[j] = Math.max(left[j], cur_left);
                else {
                    left[j] = 0;
                    cur_left = j + 1;
                } 
                    
            }
            for(int j = n - 1; j >= 0; j--) {
                if(matrix[i][j] == '1')
                    right[j] = Math.min(right[j], cur_right);
                else {
                    right[j] = n;
                    cur_right = j;
                }
            }
            for(int j = 0; j < n; j++) {
                ans = Math.max((right[j] - left[j]) * height[j], ans);
            }
            
        }
        return ans;
    }
}