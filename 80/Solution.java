class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length<3) {
            return nums.length;
        }
        return removeDuplicatesInPlace(nums);
    }

	private int removeDuplicatesAuxArray(int[] nums) {
        int[] newNums = new int[nums.length];
        newNums[0] = nums[0];
        newNums[1] = nums[1];
        
        int numsIndex = 2;
        int newNumsIndex = 2;
        while (numsIndex < nums.length) {
            if (nums[numsIndex]==nums[numsIndex-1] && nums[numsIndex]==nums[numsIndex-2]) {
                numsIndex++;
            } else {
                newNums[newNumsIndex] = nums[numsIndex];
                newNumsIndex++;
                numsIndex++;
            }
        }
        for (int i=2; i<newNumsIndex; i++) {
            nums[i] = newNums[i];
        }
        return newNumsIndex;
	}

	private int removeDuplicatesInPlace(int[] nums) {
        int numsIndex = 2;
        int newNumsIndex = 2;
        while (numsIndex < nums.length) {
            if (nums[numsIndex]==nums[newNumsIndex-1] && nums[numsIndex]==nums[newNumsIndex-2]) {
                numsIndex++;
            } else {
                swap(nums, numsIndex, newNumsIndex);
                newNumsIndex++;
                numsIndex++;
            }
        }
        return newNumsIndex;
	}

    private void swap(int[] nums, int from, int to) {
        int temp = nums[from];
        nums[from] = nums[to];
        nums[to] = temp;
    }
}
