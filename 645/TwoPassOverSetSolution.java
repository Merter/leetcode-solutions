class TwoPassOverSetSolution {
    public int[] findErrorNums(final int[] nums) {
        final Set<Integer> uniqueNums = new HashSet<>();
        int duplicateNum = -1;
        for (final int num : nums) {
            if (! uniqueNums.add(num)) {
                // according to the spec, this will hold only once
                duplicateNum = num;
            }
        }
        int missingNum = -1;
        for (int num=1; num<=nums.length; num++) {
            if (! uniqueNums.contains(num)) {
                missingNum = num;
                break;
            }
        }
        return new int[] {duplicateNum, missingNum};
    }
}
