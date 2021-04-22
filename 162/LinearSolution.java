class LinearSolution {
    public int findPeakElement(int[] nums) {
        if (nums.length==1 || nums[0]>nums[1]) {
            return 0;
        }
        for (int i=1; i<nums.length; i++) {
            if (nums[i]<=nums[i-1]) {
                continue;
            }
            if (i+1==nums.length || nums[i]>nums[i+1]) {
                return i;
            }
        }
        return nums.length-1;
    }
}
