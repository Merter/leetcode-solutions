class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int maxLen = 1;
        int currLen = 1;
        for (int i=1; i<nums.length; i++) {
            if (nums[i-1] < nums[i]) {
                currLen++;
            } else {
                maxLen = Math.max(maxLen, currLen);
                currLen = 1;
            }
        }
        return Math.max(maxLen, currLen);
    }
}
