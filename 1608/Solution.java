class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int min = 0;
        int max = nums[nums.length-1];
        while (min <= max) {
            int mid = (min+max) / 2;
            int index = Arrays.binarySearch(nums, mid);
            if (index < 0) {
                index = -(index+1);
            } else {
                // 4,4,4,4 which 4?
                while (index>0 && nums[index-1]==mid) {
                    index--;
                }
            }
            int equalOrGreaterLength = nums.length-index;
            if (mid == equalOrGreaterLength) {
                return mid;
            }
            if (mid < equalOrGreaterLength) {
                min = mid+1;
            } else {
                max = mid-1;
            }
        }
        return -1;
    }
}
