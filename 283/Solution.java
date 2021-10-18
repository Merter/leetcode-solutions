class Solution {
    public void moveZeroes(int[] nums) {
        int zeroBlockLength = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == 0) {
                zeroBlockLength++;
            } else {
                nums[i-zeroBlockLength] = nums[i];
            }        
        }
        for (int i=nums.length-zeroBlockLength; i<nums.length; i++) {
            nums[i] = 0;
        }
    }

    public void moveZeroesWithSwaps(int[] nums) {
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == 0) {
                int positionToSwap = findFirstNonzeroFrom(nums, i+1);
                if (positionToSwap == -1) return;
                swap(nums, i, positionToSwap);
            }
        }
    }
    
    private int findFirstNonzeroFrom(int[] nums, int start) {
        for (int i=start; i<nums.length; i++) {
            if (nums[i] != 0) return i;
        }
        return -1;
    }
    
    private void swap(int[] nums, int from, int to) {
        int temp = nums[from];
        nums[from] = nums[to];
        nums[to] = temp;
    }
}
