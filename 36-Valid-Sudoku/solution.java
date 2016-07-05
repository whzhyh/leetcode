public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int m = board.length, n = board[0].length;
        HashSet<Character> row = new HashSet<Character>();
        HashSet<Character> column = new HashSet<Character>();
        HashSet<Character> cube = new HashSet<Character>();
        
        for(int i = 0; i < m; i++) {
            row.clear();
            column.clear();
            cube.clear();
            for(int j = 0; j < n; j++) {
                if(board[i][j] != '.') {
                    if(row.contains(board[i][j]))
                        return false;
                    else
                        row.add(board[i][j]);
                }
                
                if(board[j][i] != '.') {
                    if(column.contains(board[j][i]))
                        return false;
                    else
                        column.add(board[j][i]);
                }
                
                char c = board[i/3*3 + j/3][i%3*3 + j%3];
                if(c != '.') {
                    if(cube.contains(c))
                        return false;
                    else
                        cube.add(c);
                }
            }
        }
        
        return true;
    }
}