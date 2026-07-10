class Solution {
    public static final int[][] directions = { {1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int orangesRotting(int[][] grid) {
        int rows = grid.length; int cols = grid[0].length;
        // check how many fresh oranges are present
        // & add rotten ones in q for bfs
        Queue<int[]> q = new ArrayDeque<>();
        int fresh = 0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] == 1)
                    fresh++;
                if(grid[i][j] == 2)
                    q.add(new int[]{i, j});
            }
        }

        int time = 0;
        while(fresh  > 0 && !q.isEmpty()){
            int size = q.size(); // count time instant at each level
            for(int i=0; i<size; i++){
                int[] t = q.poll();

                for(int[] dir : directions){
                    int r = dir[0] + t[0]; int c = dir[1] + t[1];
                    if(r >= 0 && c >= 0 && r < rows && c < cols 
                    && grid[r][c] == 1){
                        fresh--;
                        grid[r][c] = 2;
                        q.add(new int[]{r, c});
                        
                    }
                }
            }
            time++; // one level of traversal done i.e all rotten oranges at that instant did the spoilage
        }

        if(fresh > 0) return -1;
        
        return time;
    }
}
