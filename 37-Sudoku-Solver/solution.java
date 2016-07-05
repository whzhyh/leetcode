public class Solution {
    public void solveSudoku(char[][] board) {
        if(board == null || board.length == 0)
            return;
        
        solve(board);
    }
    
    public boolean solve(char[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == '.') {
                    for(char c = '1'; c <= '9'; c++) {
                        if(isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if(solve(board))
                                return true;
                            else 
                                board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean isValid(char[][] board, int row, int column, char c) {
        for(int i = 0; i < 9; i++) {
            if(board[i][column] == c)
                return false;
            
            if(board[row][i] == c)
                return false;
        }
        
        for(int i = row / 3 * 3; i < row / 3 * 3 + 3; i++) {
            for(int j = column /3 * 3; j < column / 3 * 3 + 3; j++) {
                if(board[i][j] == c)
                    return false;
            }
        }
        
        return true;
    }
}