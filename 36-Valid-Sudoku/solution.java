public class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> row = new HashSet<>();
        Set<Character> column = new HashSet<>();
        Set<Character> square = new HashSet<>();
        
        for(int i = 0; i < 9; i++) {
            row.clear();
            column.clear();
            square.clear();
            
            for(int j = 0; j < 9; j++) {
                
                if(board[i][j] != '.') {
                    char a = board[i][j];
                    if(row.contains(a)) {
                        return false;
                    } else {
                        row.add(a);
                    }    
                }
                
                if(board[j][i] != '.') { 
                    char b = board[j][i];
                    if(column.contains(b)) {
                        return false;
                    } else {
                        column.add(b);
                    }    
                }
                
                if(board[i/3*3 + j/3][i%3*3 + j%3] != '.') {  
                    char c = board[i/3*3 + j/3][i%3*3 + j%3];
                    if(square.contains(c)) {
                        return false;
                    } else {
                        square.add(c);
                    }
                }
                
            }
        }
        return true;
    }
}