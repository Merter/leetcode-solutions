class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int row=0; row<9; row++) {
            if (! validateRange(row, 0, row, 8, board)) {
                return false;
            }
        }
        for (int col=0; col<9; col++) {
            if (! validateRange(0, col, 8, col, board)) {
                return false;
            }
        }
        for (int row=0; row<9; row+=3) {
            for (int col=0; col<9; col+=3) {
                if (! validateRange(row, col, row+2, col+2, board)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean validateRange(
        int beginRow, int beginCol, int endRow, int endCol, char[][] board) {
        boolean[] foundDigits = new boolean[9];
        for (int row=beginRow; row<=endRow; row++) {
            for (int col=beginCol; col<=endCol; col++) {
                if (board[row][col] == '.') {
                    continue;
                }
                if (foundDigits[board[row][col]-'1']) {
                    return false;
                }
                foundDigits[board[row][col]-'1'] = true;
            }
        }
        return true;
    }
}
