class Solution {
    public boolean validPalindrome(String s) {
        for (int i=0; i<s.length()/2; i++) {
            if (s.charAt(i) != s.charAt(s.length()-i-1)) {
                return isPalindromeInInclusiveRange(s, i, s.length()-i-2) 
                    || isPalindromeInInclusiveRange(s, i+1, s.length()-i-1);
            }
        }
        return true;
    }
    
    private boolean isPalindromeInInclusiveRange(final String string, final int begin, final int end) {
        for (int indexOffset = 0; (begin+indexOffset < end-indexOffset); indexOffset++) {
            if (string.charAt(begin+indexOffset) != string.charAt(end-indexOffset)) {
                return false;
            }
        }
        return true;
    }
}