class Solution {
    
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // return findDisappearedNumbersWithSet(nums);
        // return findDisappearedNumbersBySorting(nums);
        return findDisappearedNumbersInPlace(nums);
    }
    
    private List<Integer> findDisappearedNumbersWithSet(int[] nums) {
        Set<Integer> uniqueNums = new HashSet<>();
        for (int i=1; i<=nums.length; i++) {
            uniqueNums.add(i);
        }
        for (int num : nums) {
            uniqueNums.remove(num);
        }
        List<Integer> disappearedNums = new ArrayList<>();
        for (int num : uniqueNums) {
            disappearedNums.add(num);
        }
        return disappearedNums;
    }
    
    private List<Integer> findDisappearedNumbersBySorting(int[] nums) {
        Arrays.sort(nums);
        List<Integer> disappearedNums = new ArrayList<>();
        int numToBeFound = 1;
        int i = 0;
        while (i<nums.length) {
            if (numToBeFound == nums[i]) {
                numToBeFound++;
                i++;
            } else if (numToBeFound < nums[i]) {
                disappearedNums.add(numToBeFound++);
            } else {    // numToBeFound > nums[i], so numToBeFound already found before
                i++;
            }
        }
        while (numToBeFound <= nums.length) {
            disappearedNums.add(numToBeFound++);
        }
        return disappearedNums;
    }
    
    private List<Integer> findDisappearedNumbersInPlace(int[] nums) {
        List<Integer> disappearedNums = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i+1) {
                i++;
                continue;
            }
            int indexToSwap = nums[i]-1;
            if (nums[indexToSwap] == nums[i]) {
                i++;
            } else {
                int temp = nums[indexToSwap];
                nums[indexToSwap] = nums[i];
                nums[i] = temp;
            }
        }
        for (int j=1; j<=nums.length; j++) {
            if (nums[j-1] != j) {
                disappearedNums.add(j);
            }
        }
        return disappearedNums;
    }
}
