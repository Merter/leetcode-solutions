class LookBehindSolution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxOneCount = 0;
        int currentOneCount = nums[0]==1 ? 1 : 0;
        for (int i=1; i<nums.length; i++) {
            if (nums[i] == 1) {
                if (nums[i-1] == 1) {
                    currentOneCount++;
                } else {
                    if (currentOneCount > maxOneCount) {
                        maxOneCount = currentOneCount;
                    }
                    currentOneCount = 1; 
                }
            } else {
                if (currentOneCount > maxOneCount) {
                    maxOneCount = currentOneCount;
                }                
                currentOneCount = 0;
            }
        }
        if (currentOneCount > maxOneCount) {
            maxOneCount = currentOneCount;
        }
        return maxOneCount;
    }
}
