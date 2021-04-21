class SolutionBySets {
    public int[] intersection(int[] nums1, int[] nums2) {
        final Set<Integer> uniqueNums1 = uniqueNums(nums1);
        final Set<Integer> uniqueNums2 = uniqueNums(nums2);
        final Set<Integer> intersection = new HashSet<>();
        for (final int uniqueNum : uniqueNums1) {
            if (uniqueNums2.contains(uniqueNum)) {
                intersection.add(uniqueNum);
            }
        }
        final int[] intersectionArray = new int[intersection.size()];
        int i = 0;
        for (final int uniqueNum : intersection) {
            intersectionArray[i++] = uniqueNum;
        }
        return intersectionArray;
    }
    
    private Set<Integer> uniqueNums(final int [] nums) {
        final Set<Integer> uniqueNums = new HashSet<>();
        for (final int num : nums) {
            uniqueNums.add(num);
        }
        return uniqueNums;
    }
}
