class Solution {
    public int countBinarySubstrings(final String str) {
        final char[] chars = str.toCharArray();
        int count = 0;
        for (int i=0; i<chars.length-1; i++) {
            if (chars[i] != chars[i+1]) {
                count++;
                int left = i-1;
                int right = i+2;
                while (left>=0 && right<chars.length && chars[left]==chars[i] && chars[i+1]==chars[right]) {
                    left--;
                    right++;
                    count++;
                }
            }
        }
        return count;
    }
}
