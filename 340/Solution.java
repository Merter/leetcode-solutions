class Solution {
    public int lengthOfLongestSubstringKDistinct(final String s, final int k) {
        if (k==0 || "".equals(s)) {
            return 0;
        }
        int begin = 0;
        int maxLength = Integer.MIN_VALUE;
        final Map<Character, Integer> char2LastPos = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            final char chr = s.charAt(i);
            Integer lastPos = char2LastPos.get(chr);
            if (lastPos==null && char2LastPos.size()==k) {
                final int charIndexToBeReplaced = Collections.min(char2LastPos.values());
                final char charToBeReplaced = s.charAt(charIndexToBeReplaced);
                char2LastPos.remove(charToBeReplaced);
                maxLength = Math.max(i-begin, maxLength);
                begin = charIndexToBeReplaced + 1;
            }
            char2LastPos.put(chr, i);
        }
        return Math.max(s.length()-begin, maxLength);
    }
}
