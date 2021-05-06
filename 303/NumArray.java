class NumArray {

    private final int[] cumulativeSums;
    
    public NumArray(final int[] nums) {
        cumulativeSums = new int[nums.length+1];
        for (int i=0; i<nums.length; i++) {
            cumulativeSums[i+1] = cumulativeSums[i]+nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        return cumulativeSums[right+1]-cumulativeSums[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
 