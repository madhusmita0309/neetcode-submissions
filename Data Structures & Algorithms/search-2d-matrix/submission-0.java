class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int rowLow = 0; int rowHi = rows-1;
        while(rowLow <= rowHi){
            int mid = (rowHi + rowLow)/2;
            if(target > matrix[mid][cols-1]){
                rowLow = mid + 1;
            }else if(target < matrix[mid][0]){
                rowHi = mid - 1;
            }else{
                break;
            }
        }

        if(!(rowLow <= rowHi))
            return false;
        
        int row = (rowLow + rowHi) /2;
        int colLow = 0; int colHi = cols-1;
        while( colLow <= colHi ){
            int mid = (colLow + colHi)/2;
            if(target > matrix[row][mid]){
                colLow = mid + 1;
            }else if(target < matrix[row][mid]){
                colHi = mid - 1;
            }else{
                return true;
            } 
        }

        return false;
    }
}
