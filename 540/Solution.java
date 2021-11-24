class Solution {
    public int singleNonDuplicate(int[] nums) {
        int begin = 0;
        int end = nums.length-1;
        while (begin < end) {
            int mid = (begin+end) / 2;
            if (nums[mid] == nums[mid+1]) {
                mid++;
            } else if (nums[mid] != nums[mid-1]) {
                return nums[mid];
            }
            if ((mid-begin)%2 == 1) { // the single element is on the right half
                begin = mid+1;
            } else { // the single element is on the left half
                end = mid-2;
            }
        }
        return nums[begin];
    }
}
