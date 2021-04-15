class Solution {
    public int lengthOfLongestSubstring(String s) {
        final Map<Character, Integer> char2LastIndex = new HashMap<>();
        int maxLength = 0;
        int currStart = 0;
        final char[] sChars = s.toCharArray();
        for (int i=0; i<sChars.length; i++) {
            final char chr = sChars[i];
            final Integer lastIndex = char2LastIndex.get(chr);
            if (lastIndex!=null && lastIndex>=currStart) {
                maxLength = Math.max(maxLength, i-currStart);
                currStart = lastIndex+1;
            }
            char2LastIndex.put(chr, i);
        }
        return Math.max(maxLength, s.length()-currStart);
    }
}
