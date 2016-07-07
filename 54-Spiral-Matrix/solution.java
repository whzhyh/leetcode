public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return ans;
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        int x = 0, y = 0;
        int idx = 0;
        while(true) {
            if(ans.size() == m * n)
                break;
            if(x < m && y < n && x >= 0 && y >= 0 && visited[x][y] != true) {
                ans.add(matrix[x][y]);
                visited[x][y] = true;
                x += directions[idx][0];
                y += directions[idx][1];
            } else {
                x -= directions[idx][0];
                y -= directions[idx][1];
                idx = (idx + 1) % 4;
                x += directions[idx][0];
                y += directions[idx][1];
            }   
        }
        return ans;
    }
}