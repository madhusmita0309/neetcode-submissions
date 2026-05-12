class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, HashSet<Character>> rowMap = new HashMap<>();
        HashMap<Integer, HashSet<Character>> colMap = new HashMap<>();
        HashMap<String, HashSet<Character>> sqMap = new HashMap<>();

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j] == '.')
                    continue;
                
                String sqKey = i/3+","+j/3;
                if(rowMap.computeIfAbsent(i, k -> new HashSet<>()).contains(board[i][j]) || 
                   colMap.computeIfAbsent(j, k -> new HashSet<>()).contains(board[i][j]) ||
                   sqMap.computeIfAbsent(sqKey, k -> new HashSet<>()).contains(board[i][j]))
                   return false;
                
                rowMap.get(i).add(board[i][j]);
                colMap.get(j).add(board[i][j]);
                sqMap.get(sqKey).add(board[i][j]);
            }
        }

        return true;
    }
}
