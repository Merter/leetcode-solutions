class SinglePassOverSetSolution {
    public int[] findErrorNums(final int[] nums) {
        final Set<Integer> uniqueNums = new HashSet<>();
        int duplicateNum = -1;
        final int expectedSum = nums.length*(nums.length+1) / 2;
        int actualSum = 0;
        for (final int num : nums) {
            if (! uniqueNums.add(num)) {
                // according to the spec, this will hold only once
                duplicateNum = num;
            } else {
                actualSum += num;
            }
        }
        final int missingNum = expectedSum - actualSum;
        return new int[] {duplicateNum, missingNum};
    }
}
