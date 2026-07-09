class Solution {
    public static final int [][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public void islandsAndTreasure(int[][] grid) {
        // find the treasure cells and add to queue
        int rows = grid.length; int cols  = grid[0].length;
     

        Queue<int[]> q = new ArrayDeque<>();
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] == 0)
                    q.add(new int[]{i, j}); // add cells with treasure

            }
        }

        if(q.size() == 0)   return;

        while(!q.isEmpty()){
            int[] d = q.poll();
        

            for(int[] dir : directions){
                int r = dir[0] + d[0]; int c = dir[1] + d[1];
                if(r < 0 || c < 0 || r >= rows || c >= cols
                    || grid[r][c] != Integer.MAX_VALUE ){
                        
                        continue;
                    }
                    q.add(new int[]{r, c});
                    grid[r][c] = grid[d[0]][d[1]] + 1; 
            }
            
        }
    }
}
