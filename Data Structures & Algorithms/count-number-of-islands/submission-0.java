class Solution {
    public static final int[][] directions = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
    //int[][] visited;
    public int numIslands(char[][] grid) {
        if(grid.length == 0)
            return 0;
        
        int rows = grid.length;
        int cols = grid[0].length;
        //int[][] visited = new int[rows][cols];

        int islands = 0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] == '1'){
                    bfs(i,j, grid);
                    islands++;
                }
            }
        }
        return islands;
    }

    public void bfs(int r, int c, char[][] grid){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{r, c});
        grid[r][c] = '0'; // visited

        while(!q.isEmpty()){
            int[] dir = q.poll();
            
            for(int[] d : directions){
                int row = dir[0] + d[0]; int col = dir[1] + d[1];

                if(row >= 0 && col >= 0 && row < grid.length && col < grid[0].length
                    && grid[row][col] == '1' ){
                        q.add(new int[]{row, col});
                        grid[row][col] = '0'; // visited

                }
            
            }
        }
    }
}
