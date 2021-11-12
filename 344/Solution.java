class Solution {
    public void reverseString(char[] s) {
        for (int i=0; i<s.length/2 ;i++) {
            swap(s, i, s.length-1-i);
        }
    }
    
    private void swap(final char[] chars, final int from, final int to) {
        final char temp = chars[from];
        chars[from] = chars[to];
        chars[to] = temp;
    }
}