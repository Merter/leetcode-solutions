class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        if (m*n!=r*c || m==r) {
            return mat;
        }
        int[][] reshaped = new int[r][c];
        int mIndex = 0;
        int nIndex = 0;
        for (int row=0; row<r; row++) {
            for (int col=0; col<c; col++) {
                if (nIndex == n) {
                    nIndex = 0;
                    mIndex++;
                }
                reshaped[row][col] = mat[mIndex][nIndex++];
            }
        }
        return reshaped;
    }
}
