class Solution {
    public int findMaxConsecutiveOnes(final int[] nums) {
        int maxOneCount = 0;
        int currentOneCount = 0;
        for (final int num : nums) {
            if (num == 1) {
                currentOneCount++;
            } else {
                maxOneCount = Math.max(currentOneCount, maxOneCount);
                currentOneCount = 0;
            }
        }
        maxOneCount = Math.max(currentOneCount, maxOneCount);
        return maxOneCount;        
    }
}
