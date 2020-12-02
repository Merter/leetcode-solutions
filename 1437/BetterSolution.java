class BetterSolution {
    public boolean kLengthApart(int[] nums, int k) {
        if (k==0 || nums.length==1) {
            return true;
        }
        int onePosition = -1;
        for (int index=0; index<nums.length; index++) {
            if (nums[index] == 1) {
                if (onePosition == -1) {
                    onePosition = index;
                    continue;
                }
                if (index-onePosition <= k) {
                    return false;
                }
                onePosition = index;
            }
        }
        return true;
    }
}
