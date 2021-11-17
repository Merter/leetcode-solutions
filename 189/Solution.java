class Solution {
    
    public void rotate(int[] nums, int k) {
        int rotationCount = k % nums.length;
        if (rotationCount == 0) {
            return;
        }
        rotateWithReversing(nums, rotationCount);
    }
    
    private void rotateWithAuxArray(int[] nums, int rotationCount) {
        int[] rotatedNums = new int[nums.length];
        for (int i=0; i<nums.length; i++) {
            int rotatedIndex = (rotationCount+i) % rotatedNums.length;
            rotatedNums[rotatedIndex] = nums[i];
        }
        for (int i=0; i<nums.length; i++) {
            nums[i] = rotatedNums[i];
        }
    }
    
    private void rotateWithReversing(int[] nums, int rotationCount) {
        reverseRange(nums, 0, nums.length-1);
        reverseRange(nums, 0, rotationCount-1);
        reverseRange(nums, rotationCount, nums.length-1);
    }
    
    private void reverseRange(int[] nums, int begin, int end) {
        for (int i=0; i<(end-begin+1)/2; i++) {
            swap(nums, begin+i, end-i);
        }
    }
    
    private void swap(int[] nums, int from, int to) {
        int temp = nums[from];
        nums[from] = nums[to];
        nums[to] = temp;        
    }
}
