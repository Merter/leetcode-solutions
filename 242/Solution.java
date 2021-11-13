class Solution {
    
    private static final int CHARSET_SIZE = 26;
    
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        return isAnagramByCounting(s, t);
    }
    
    private boolean isAnagramBySorting(String s, String t) {
        return canonicalForm(s).equals(canonicalForm(t));
    }
    
    private String canonicalForm(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
    
    private boolean isAnagramByCounting(String s, String t) {
        int[] sCharCounts = charCounts(s);
        int[] tCharCounts = charCounts(t);
        for (int i=0; i<CHARSET_SIZE; i++) {
            if (sCharCounts[i] != tCharCounts[i]) {
                return false;
            }
        }
        return true;
    }
    
    private int[] charCounts(String s) {
        int[] charCounts = new int[CHARSET_SIZE];
        for (char chr : s.toCharArray()) {
            charCounts[chr-'a']++;
        }
        return charCounts;
    }
}