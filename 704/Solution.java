class Solution {
    public int search(final int[] nums, final int target) {
        int begin = 0;
        int end = nums.length-1;
        while (begin <= end) {
            final int mid = begin+(end-begin)/2;
            if (target == nums[mid]) {
                return mid;
            }
            if (nums[mid] < target) {
                begin = mid+1;
            } else {
                end = mid-1;
            }
        }
        return -1;
    }
}
