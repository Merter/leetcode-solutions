class NumMatrix {

    private final int[][]sums;
    
    public NumMatrix(final int[][] matrix) {
        sums = new int[matrix.length][matrix[0].length+1];
        for (int row=0; row<matrix.length; row++) {
            for (int col=0; col<matrix[row].length; col++) {
                sums[row][col+1] = sums[row][col] + matrix[row][col];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int row=row1; row<=row2; row++) {
            sum += sums[row][col2+1] - sums[row][col1];
        }        
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
 