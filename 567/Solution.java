class Solution {
    public boolean checkInclusion(final String source, final String target) {
        if (target.length() < source.length()) {
            return false;
        }
        final String sortedSource = sortChars(source);

        final int windowSize = source.length();
        for (int i=0; i<=target.length()-windowSize; i++) {
            final String substr = target.substring(i, i+windowSize);
            final String sortedSubstr = sortChars(substr);
            if (sortedSource.equals(sortedSubstr)) {
                return true;
            }
        }
        return false;
    }
    
    private String sortChars(final String source) {
        char[] sortedChars = source.toCharArray();
        Arrays.sort(sortedChars);
        return new String(sortedChars);
    }
}
