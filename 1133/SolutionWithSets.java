class SolutionWithSets {
    public int largestUniqueNumber(final int[] nums) {
        final Set<Integer> repeatedNums = new HashSet<>();
        final TreeSet<Integer> maxes = new TreeSet<>();
        for (final int num : nums) {
            if (repeatedNums.contains(num)) {
                continue;
            }
            if (maxes.contains(num)) {
                maxes.remove(num);
                repeatedNums.add(num);
                continue;
            }
            maxes.add(num);
        }
        return maxes.isEmpty() ? -1 : maxes.pollLast();
    }
}
