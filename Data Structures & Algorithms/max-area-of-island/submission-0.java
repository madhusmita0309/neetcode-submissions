class Solution {
    public static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int maxAreaOfIsland(int[][] grid) {
        if(grid.length == 0)
            return 0;
        int rows = grid.length; int cols = grid[0].length;

        int area = 0;
        int maxArea = 0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] == 1){
                    area = bfs(i, j, grid);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }

    public int bfs(int r, int c, int[][] grid){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{r, c});
        int area = 1; // imp as starting cell needs to be counted
        grid[r][c] = 0; // visited

        while(!q.isEmpty()){
            int[] d = q.poll();
            for(int[] dir : directions){
                int row = dir[0] + d[0];
                int col = dir[1] + d[1];

                if(row < grid.length && col < grid[0].length && row >= 0 && col >= 0
                    && grid[row][col] == 1){
                        q.add(new int[]{row, col});
                        grid[row][col] = 0; // visited
                        area++;
                    }
            }
        }
        //System.out.println(area);
        return area;
    }
}
