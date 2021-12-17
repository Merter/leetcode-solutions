class Solution {
    public int maximalSquare(char[][] matrix) {
        int[][]cache = new int[matrix.length][matrix[0].length];
        int maxSide = 0;
        for (int row=0; row<matrix.length; row++) {
            for (int col=0; col<matrix[0].length; col++) {
                if (row==0 || col==0) {
                    cache[row][col] = matrix[row][col] - '0';
                } else {                    
                    if (matrix[row][col] == '1') {
                        cache[row][col] = Math.min(
                            cache[row-1][col-1],
                            Math.min(cache[row][col-1], cache[row-1][col])) + 1;
                    }
                }
                maxSide = Math.max(maxSide, cache[row][col]);
            }
        }
        return maxSide*maxSide;
    }
}
