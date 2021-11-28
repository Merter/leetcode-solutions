class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int sumEndingWithItem = nums[0];
        for (int i=1; i<nums.length; i++) {
            sumEndingWithItem = Math.max(nums[i], sumEndingWithItem+nums[i]);
            maxSum = Math.max(maxSum, sumEndingWithItem);
        }
        return maxSum;
    }
}
