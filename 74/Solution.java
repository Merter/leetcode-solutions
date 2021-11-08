class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int begin = 0;
        int end = matrix.length*matrix[0].length-1;
        while (begin <= end) {
            int mid = (begin+end) / 2;
            int[] rowAndCol = translatePosToRowAndColumn(mid, matrix[0].length);
            int posValue = matrix[rowAndCol[0]][rowAndCol[1]];
            if (posValue == target) {
                return true;
            }
            if (posValue < target) {
                begin = mid+1;
            } else {
                end = mid-1;
            }
        }
        return false;
    }
    
    private int[] translatePosToRowAndColumn(int pos, int colCount) {
        int row = pos / colCount;
        int col = pos % colCount;
        return new int[]{row, col};
    }
}
