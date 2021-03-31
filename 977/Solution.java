class Solution {
    public int[] sortedSquares(final int[] nums) {
        final int[] squares = new int[nums.length];
        for (int i=0; i<nums.length; i++) {
            squares[i] = nums[i] * nums[i];
        }
        if (squares.length==1 ||  squares[0]<squares[1]) {
            return squares;
        }
        final int[] sortedSquares = new int [squares.length];
        int changePoint = 0;
        while (changePoint+1<squares.length && squares[changePoint]>=squares[changePoint+1]) {
            changePoint++;
        }
        if (changePoint == squares.length) {
            for (int i=0; i<squares.length; i++) {
                sortedSquares[i] = squares[squares.length-1-i];
            }
            return sortedSquares;
        }
        int leftIndex = changePoint-1;
        int rightIndex = changePoint;
        int index = 0;
        while (index < sortedSquares.length) {
            if (leftIndex >= 0) {
                // squares of negatives are still unsorted
                if (rightIndex == squares.length) {
                    sortedSquares[index] = squares[leftIndex--];
                } else {
                    if (squares[leftIndex] > squares[rightIndex]) {
                        sortedSquares[index] = squares[rightIndex++];
                    } else {
                        sortedSquares[index] = squares[leftIndex--];
                    }
                }
            } else {
                sortedSquares[index] = squares[rightIndex++];
            }
            index++;
        }
        return sortedSquares;
    }
}
