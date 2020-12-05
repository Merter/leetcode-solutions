class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        int arrIndex = 0;
        while (arrIndex < arr.length) {
            int num = arr[arrIndex];
            boolean pieceConsumed = false;
            for (int[] piece : pieces) {
                if (num == piece[0]) {
                    arrIndex++;
                    for (int i=1; i<piece.length; i++) {
                        if (arr[arrIndex++] != piece[i]) { // [5,1] [[5,0]]
                            return false;
                        }
                    }
                    // [5] [[5]] or [5,0] [[5,0]]
                    // ie a piece is found
                    pieceConsumed = true;
                    break;
                }
            }
            if (!pieceConsumed) { // [5] [[2]]
                return false;
            }            
        }
        return true;
    }
}