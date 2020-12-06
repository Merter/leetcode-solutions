class Solution {
    public String reverseOnlyLetters(String str) {
        char[] chars = str.toCharArray();
        int beginIndex = 0;
        int endIndex = chars.length-1;
        while (true) {
            while (beginIndex<endIndex && !isLetter(chars[beginIndex])) {
                beginIndex++;
            }
            while (beginIndex<endIndex && !isLetter(chars[endIndex])) {
                endIndex--;
            }
            if (beginIndex >= endIndex) {
                break;
            }
            swap(chars, beginIndex, endIndex);
            beginIndex++;
            endIndex--;
        }
        return new String(chars);
    }
    
    private boolean isLetter(char chr) {
        if (chr-'a' >= 0) {
            return true;
        }
        if ((chr-'A' >= 0) && (chr-'Z' <= 0)) {
            return true;
        }
        return false;
    }
    
    private void swap(char[] chars, int from, int to) {
        char temp = chars[from];
        chars[from] = chars[to];
        chars[to] = temp;
    }
}
