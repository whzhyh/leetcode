public class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Integer> row = new HashSet<>();
        Set<Integer> column = new HashSet<>();
        Set<Integer> square = new HashSet<>();
        
        for(int i = 0; i < 9; i++) {
            row = new HashSet<>();
            column = new HashSet<>();
            square = new HashSet<>();
            System.out.println();
            for(int j = 0; j < 9; j++) {
                
                if(board[i][j] != '.') {
                    int a = board[i][j] - '0';
                    if(row.contains(a)) {
                        return false;
                    } else {
                        row.add(a);
                    }    
                }
                
                if(board[j][i] != '.') { 
                    int b = board[j][i] - '0';
                    if(column.contains(b)) {
                        return false;
                    } else {
                        column.add(b);
                    }    
                }
                
                // System.out.println((i/3*3 + j/3) + " : " + (j%3 + i%3*3));
                if(board[i/3*3 + j/3][j%3 + i%3*3] != '.') {  
                    int c = board[i/3*3 + j/3][j%3 + i%3*3] - '0';
                    
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