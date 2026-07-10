class Solution {
   
    public void solve(char[][] board) {
        int rows = board.length;  int cols = board[0].length;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(board[i][j] == 'O' && isEdge(i, j, rows, cols)){
                    capture(board, i, j);
                }
            }
        }

        // change all O to X becoz they are surrounded areas for sure
        // change all T to O as they cannot be surrounded
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                if(board[i][j] == 'T')
                    board[i][j] = 'O';
            }
        }

    }

    public void capture(char[][] board, int r, int c){

        if(r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] != 'O')
            return;
        
        board[r][c] = 'T';
        capture(board,  r + 1,  c);
        capture(board,  r ,  c + 1);
        capture(board,  r - 1,  c);
        capture(board,  r ,  c - 1);
    }

    public boolean isEdge(int i, int j, int rows, int cols){
        if(i == 0 || j == 0 || i == rows-1 || j == cols-1)
            return true;
        else 
            return false;  
    }
}
