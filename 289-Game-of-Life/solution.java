public class Solution {
    // four states: 0 -> 0, 0 -> 1, 1 -> 0, 1 -> 1
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0 || board[0] == null || board[0].length == 0)
            return;
        int m = board.length;
        int n = board[0].length;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int lives = neighborsLives(board, i, j);
                if(board[i][j] == 0 && lives == 3) {
                    board[i][j] = 2;
                }
                if(board[i][j] == 1) {
                    if(lives < 2 || lives > 3)
                        board[i][j] = 1;
                    if(lives >= 2 && lives <= 3)
                        board[i][j] = 3;
                }
            }
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) { 
                board[i][j] = (board[i][j] & 2) >> 1;   
            }
        }
        
    }
    public int neighborsLives(int[][] board, int x, int y) {
        int m = board.length;
        int n = board[0].length;
        int count = 0;
        for(int i = Math.max(0, x - 1); i <= Math.min(m - 1, x + 1); i++) {
            for(int j = Math.max(0, y - 1); j <= Math.min(n - 1, y + 1); j++) {
                if(i == x && j == y)
                    continue;
                if((board[i][j] & 1) == 1) 
                    count++;
            }
        }
        return count;
    }
}