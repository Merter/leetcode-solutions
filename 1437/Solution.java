class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        if (k==0 || nums.length==1) {
            return true;
        }
        int onePosition = 0;
        while (onePosition < nums.length){
            if (nums[onePosition] == 1) {
                break;
            }
            onePosition++;
        }
        if (onePosition == nums.length) {
            return true;
        }
        int index = onePosition+1;
        while (index < nums.length) {
            if (nums[index] == 1) {
                if (index-onePosition <= k) {
                    return false;
                }
                onePosition = index;
            }
            index++;
        }
        return true;
    }
}
