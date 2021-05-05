class Solution {
    public boolean wordBreak(final String s, final List<String> wordDict) {
        final Set<String> dict = new HashSet<>();
        for (final String word : wordDict) {
            dict.add(word);
        }
        final Boolean[] startResults = new Boolean[s.length()];
        return wordBreakStartingFrom(s, 0, dict, startResults);
    }
    
    private boolean wordBreakStartingFrom(
        final String s, final int start, final Set<String> dict, final Boolean[] startResults) {
        if (start == s.length()) {
            return true;
        }
        if (startResults[start] != null) {
            return startResults[start];
        }
        for (int end=start+1; end<=s.length(); end++) {
            if (dict.contains(s.substring(start, end))) {
                final boolean isSuffixInDict = wordBreakStartingFrom(s, end, dict, startResults);
                if (isSuffixInDict) {
                    startResults[start] = true;
                    return true;
                }
            }
        }
        startResults[start] = false;
        return false;
    }
}
