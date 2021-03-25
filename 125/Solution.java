class Solution {
    public boolean isPalindrome(String s) {
        final StringBuilder stb = new StringBuilder();
        for (final char chr : s.toLowerCase().toCharArray()) {
            if (chr-'a'>=0 && chr-'a'<26) {
                stb.append(chr);
            }
            if (chr-'0'>=0 && chr-'0'<10) {
                stb.append(chr);
            }            
        }
        final String sanitizedString = stb.toString();
        for (int i=0; i<sanitizedString.length()/2; i++) {
            if (sanitizedString.charAt(i) != sanitizedString.charAt(sanitizedString.length()-i-1)) {
                return false;
            }
        }
        return true;
    }
}
