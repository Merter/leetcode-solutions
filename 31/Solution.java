class Solution {
    public void nextPermutation(final int[] nums) {
        if (nums==null || nums.length<2) {
            return;
        }
        int indexFromRight = nums.length-1;
        while (indexFromRight >= 1) {
            if (nums[indexFromRight] > nums[indexFromRight-1]) {
                break;
            }
            indexFromRight--;
        }
        if (indexFromRight == 0) {
            reverseStartingFrom(nums, 0);
            return;
        }
        final int indexToBeSwapped = indexFromRight-1;
        while (indexFromRight<nums.length && nums[indexFromRight]>nums[indexToBeSwapped]) {
            indexFromRight++;
        }
        swap(nums, indexToBeSwapped, indexFromRight-1);
        reverseStartingFrom(nums, indexToBeSwapped+1);
    }
    
    private void reverseStartingFrom(final int[] nums, final int begin) {
        final int end = nums.length-1;
        for (int offset=0; offset<(end-begin+1)/2; offset++) {
            swap(nums, begin+offset, end-offset);
        }
    }
    
    private void swap(final int[] nums, final int from, final int to) {
        final int temp = nums[from];
        nums[from] = nums[to];
        nums[to] = temp;
    }
}