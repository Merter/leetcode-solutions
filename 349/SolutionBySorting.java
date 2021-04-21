class SolutionBySorting {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        final Set<Integer> intersection = new HashSet<>();
        for (final int num : nums2) {
            if (Arrays.binarySearch(nums1, num) >= 0) {
                intersection.add(num);
            }
        }
        final int[] intersectionArray = new int[intersection.size()];
        int i = 0;
        for (final int uniqueNum : intersection) {
            intersectionArray[i++] = uniqueNum;
        }
        return intersectionArray;
    }
}
