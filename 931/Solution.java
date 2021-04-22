class Solution {
    public int minFallingPathSum(final int[][] matrix) {
        final int matrixLen = matrix.length;
        for (int row=matrixLen-2; row>=0; row--) {
            for (int col=0; col<matrixLen; col++) {
                int minChild = matrix[row+1][col];
                if (col > 0)
                    minChild = Math.min(minChild, matrix[row+1][col-1]);
                if (col+1 < matrixLen)
                    minChild = Math.min(minChild, matrix[row+1][col+1]);
                matrix[row][col] += minChild;
            }
        }
        int minSum = Integer.MAX_VALUE;
        for (int sum: matrix[0]) {
            minSum = Math.min(minSum, sum);
        }
        return minSum;
    }
}
