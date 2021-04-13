class SolutionBySorting {
    public int largestUniqueNumber(final int[] nums) {
        Arrays.sort(nums);
        int maxCount = 1;
        int maxIndex = nums.length-2;
        while (maxIndex >= 0) {
            if (nums[maxIndex] == nums[maxIndex+1]) {
                maxCount++;
            } else {
                if (maxCount == 1) {
                    return nums[maxIndex+1];
                }
                maxCount = 1;
            }
            maxIndex--;
        }
        return (maxCount==1) ? nums[0] : -1;
    }
}