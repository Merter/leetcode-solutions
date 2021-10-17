class Solution {
    public int[] sortedSquares(int[] nums) {
        for (int i=0; i<nums.length; i++) {
            nums[i] *= nums[i];
        }
        int[] sortedSquares = new int[nums.length];
        int rightIndex = 0;
        int leftIndex = nums.length-1;
        int sortedSquaresIndex = nums.length-1;
        for (int i=sortedSquares.length-1; i>=0; i--) {
            if (nums[rightIndex] > nums[leftIndex]) {
                sortedSquares[i] = nums[rightIndex++];
            } else {
                sortedSquares[i] = nums[leftIndex--];
            }
        }
        return sortedSquares;
    }
}

