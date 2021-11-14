class Solution {
    public boolean containsDuplicate(int[] nums) {
        return containsDuplicateBySort(nums);
    }
    
    private boolean containsDuplicateBySet(int[] nums) {
        Set<Integer> uniqueNums = new HashSet<>();
        for (int num : nums) {
            if (uniqueNums.contains(num)) {
                return true;
            }
            uniqueNums.add(num);
        }
        return false;
    }
    
    private boolean containsDuplicateBySort(int[] nums) {
        Arrays.sort(nums);
        int prev = nums[0];
        for (int i=1; i<nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                return true;
            }
        }
        return false;
    }
}
