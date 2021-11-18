class Solution {
    public int uniquePaths(int row, int col) {
        int big = row>col ? row-1 : col-1;
        int small = row<col ? row-1 : col-1;
        
        long nominator = 1L;
        long denominator = 1L;
        for (int i=1; i<=small; i++) {
            nominator *= big+i;
            denominator *= i;
        }
        return (int)(nominator / denominator);
    }
}
