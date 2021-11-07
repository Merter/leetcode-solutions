class Solution {
    public boolean checkInclusion(String s1, String s2) {
        return checkInclusionWithCharCountMatching(s1, s2);
    }

    private boolean checkInclusionWithCharCountMatching(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }
        int[] canonicalS1 = canonicalForm(s1);
        int begin = 0;
        int[] canonicalSubS2 = canonicalForm(s2.substring(begin, s1.length()-1));
        for (int end=s1.length()-1; end<s2.length(); end++) {
            canonicalSubS2[s2.charAt(end)-'a']++;
            if (matches(canonicalS1, canonicalSubS2)) {
                return true;
            }
            canonicalSubS2[s2.charAt(begin++)-'a']--;
        }
        return false;
    }
    
    private int[] canonicalForm(String str) {
        int[] charCounts = new int[26];
        for (int i=0; i<str.length(); i++) {
            charCounts[str.charAt(i)-'a']++;
        }
        return charCounts;
    }
    
    private boolean matches(int[] charCounts1, int[]charCounts2) {
        for (int i=0; i<charCounts1.length; i++) {
            if (charCounts1[i] != charCounts2[i]) {
                return false;
            }
        }
        return true;
    }

    private boolean checkInclusionWithSorting(final String source, final String target) {
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
