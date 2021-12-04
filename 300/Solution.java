class Solution {
    public int lengthOfLIS(int[] nums) {
        return lengthOfLISWithBinarySearch(nums);
    }

    private int lengthOfLISWithBinarySearch(int[] nums) {
        int[] lis = new int[nums.length];
        int lisExclusiveEnd = 0;
        for (int num : nums) {
            int pos = Arrays.binarySearch(lis, 0, lisExclusiveEnd, num);
            if (pos >= 0) {
                continue;
            }
            pos = -pos-1;
            lis[pos] = num;
            if (pos == lisExclusiveEnd) {
                lisExclusiveEnd++;
            }
        }
        return lisExclusiveEnd;
    }

    private int lengthOfLISWithMemoization(int[] nums) {
        if (nums==null || nums.length==0) {
            return 0;
        }
        int[] maxLISLengths = new int[nums.length];
        int maxLISLength = 1;
        for (int i=0; i<nums.length; i++) {
            maxLISLengths[i] = 1;
            for (int j=i-1; j>=0; j--) {
                if (nums[j] < nums[i]) {
                    int currentLISLength = maxLISLengths[j]+1;
                    maxLISLengths[i] = Math.max(currentLISLength, maxLISLengths[i]);
                    maxLISLength = Math.max(maxLISLength, maxLISLengths[i]);
                }
            }
        }
        return maxLISLength;
    }
}