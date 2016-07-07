public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return ans;
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        int i = 0, j = 0;
        int idx = 0;
        while(true) {
            if(ans.size() == m * n)
                break;
            if(i < m && j < n && i >= 0 && j >= 0 && visited[i][j] != true) {
                ans.add(matrix[i][j]);
                visited[i][j] = true;
                i += directions[idx][0];
                j += directions[idx][1];
            } else {
                i -= directions[idx][0];
                j -= directions[idx][1];
                idx = (idx + 1) % 4;
                i += directions[idx][0];
                j += directions[idx][1];
            }   
        }
        return ans;
    }
}