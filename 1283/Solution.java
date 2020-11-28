class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int min = 1;
        int max = maxInArray(nums);
        while (true) {
            if (min == max) {
                return min;
            }
            if (min+1 == max) {
                int sumQuotients = sumQuotients(nums, min);
                return sumQuotients <= threshold ? min : max;
            }
            int mid = (min+max) / 2;
            int sumQuotients = sumQuotients(nums, mid);
            if (sumQuotients > threshold) {
                min = mid;
                continue;
            }
            max = mid;
        }
    }
    
    private int maxInArray(int[] nums) {
        int maxPos = 0;
        for (int i=1; i<nums.length; i++) {
            if (nums[i] > nums[maxPos]) {
                maxPos = i;
            }
        }
        return nums[maxPos];
    }
    
    private int sumQuotients(int[] nums, int divisor) {
        int sumQuotients = 0;
        for (int num: nums) {
            sumQuotients += ((num + (divisor-1)) / divisor);
        }
        return sumQuotients;
    }
}
