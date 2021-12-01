class Solution {
    public void nextPermutation(int[] nums) {
        int lastIncreaseIndex = nums.length-1;
        while (lastIncreaseIndex>0 && nums[lastIncreaseIndex-1]>=nums[lastIncreaseIndex]) lastIncreaseIndex--;
        if (lastIncreaseIndex == 0) {
            reverseStartingFrom(nums, 0);
            return;
        }
        int lastIndexOfTheNextBiggest = lastIncreaseIndex--;
        for (int i=lastIndexOfTheNextBiggest; i<nums.length; i++) {
            if (nums[lastIncreaseIndex]<nums[i] && nums[i]<=nums[lastIndexOfTheNextBiggest]) {
                lastIndexOfTheNextBiggest = i;
            }
        }
        swap(nums, lastIncreaseIndex, lastIndexOfTheNextBiggest);
        reverseStartingFrom(nums, lastIncreaseIndex+1);
    }
    
    private void reverseStartingFrom(int[] nums, int start) {
        for (int offset=0; offset<(nums.length-start)/2; offset++) {
            swap(nums, start+offset, nums.length-1-offset);
        }
    }
    
    private void swap(int[] nums, int from, int to) {
        int temp = nums[from];
        nums[from] = nums[to];
        nums[to] = temp;
    }
}
