class Solution {
    int rows;
    int cols;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        rows = heights.length;  cols = heights[0].length;
        int[][] pacific = new int[rows][cols]; int[][] atlantic = new int[rows][cols];

        for(int i=0; i<cols; i++){
            dfs(0, i, pacific, heights);
            dfs(rows-1, i, atlantic, heights);

        }

        for(int i=0; i<rows; i++){
            dfs(i, 0, pacific, heights);
            dfs(i, cols-1, atlantic, heights);
        }

        List<List<Integer>> result = new ArrayList();
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(pacific[i][j] ==1 && atlantic[i][j] == 1){
                    result.add(Arrays.asList(i, j));
                }

            }
        }

        return result;
    }

    public void dfs(int r, int c, int[][] visited, int[][] heights){
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        visited[r][c] = 1;
        for(int[] d: directions){
            int row = r + d[0]; int col = c + d[1];
            if(row >= 0 && row < rows && col >= 0 && col < cols 
            && heights[row][col] >= heights[r][c] && visited[row][col] != 1){
                dfs(row, col, visited, heights);
            }

        }
    }
}
