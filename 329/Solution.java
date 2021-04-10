class Solution {
    
    private int[][]matrix;
    private int[][]dist;
    private int maxPathLength;
    
    public int longestIncreasingPath(final int[][] matrix) {
        this.matrix = matrix;
        dist = new int[matrix.length][matrix[0].length];
        for (int row=0; row<matrix.length; row++) {
            for (int col=0; col<matrix[row].length; col++) {
                traverseMatrix(row, col, 1);
            }
        }
        return maxPathLength;
    }
    
    private void traverseMatrix(
        final int row, final int col, final int inclusiveLength) {
        if (dist[row][col] >= inclusiveLength) {
            return;
        }
        dist[row][col] = inclusiveLength;
        maxPathLength = Math.max(maxPathLength, inclusiveLength);
        if (row>0 && matrix[row-1][col] > matrix[row][col]) {
            traverseMatrix(row-1, col, inclusiveLength+1);
        }
        if (row<matrix.length-1 && matrix[row+1][col] > matrix[row][col]) {
            traverseMatrix(row+1, col, inclusiveLength+1);
        }
        if (col>0 && matrix[row][col-1] > matrix[row][col]) {
            traverseMatrix(row, col-1, inclusiveLength+1);
        }
        if (col<matrix[row].length-1 && matrix[row][col+1] > matrix[row][col]) {
            traverseMatrix(row, col+1, inclusiveLength+1);
        }
    }
}
