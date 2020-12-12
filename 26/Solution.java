class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int numsIndex = 1;
        int newNumsIndex = 1;
        while (numsIndex < nums.length) {
            if (nums[numsIndex] != nums[newNumsIndex-1]) {
                swap(nums, numsIndex, newNumsIndex);
                newNumsIndex++;
            }
            numsIndex++;
        }
        return newNumsIndex;
    }
    
    private void swap(int[] nums, int from, int to) {
        int temp = nums[from];
        nums[from] = nums[to];
        nums[to] = temp;
    }
}
