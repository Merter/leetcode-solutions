class SolutionBySorting {
    public List<Integer> findAnagrams(final String longer, final String target) {
        final List<Integer> startIndexes = new ArrayList<>();
        if (longer.length() < target.length()) {
            return startIndexes;
        }
        final String canonicalSortedTarget = canonicalSorted (target);
        for (int i=0; i<=longer.length()-target.length(); i++) {
            final String canonicalSortedSubLonger = canonicalSorted(longer.substring(i, i+target.length()));
            if (canonicalSortedSubLonger.equals(canonicalSortedTarget)) {
                startIndexes.add(i);
            }
        }
        return startIndexes;
    }
    
    private String canonicalSorted(final String str) {
        final char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }
}
