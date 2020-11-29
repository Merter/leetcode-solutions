class Solution {
    
    private static final String DELIMITER = " ";
    private static final char DELIMITER_CHAR = ' ';
    
    public String reverseWords(String s) {
        String[] words = s.split(DELIMITER);
        StringBuilder stb = new StringBuilder();
        for (String word : words) {
            stb.append(reverseString(word));
            stb.append(DELIMITER);
        }
        return stb.toString().trim();
    }
    
    private String reverseString(String string) {
        char[] chars = string.toCharArray();
        for (int i=0; i<chars.length/2; i++) {
            char temp = chars[i];
            chars[i] = chars[chars.length-i-1];
            chars[chars.length-i-1] = temp;
        }
        return new String(chars);
    }
    
    public String reverseWordsInPlace(String string) {
        char[] chars = string.toCharArray();
        int begin = 0;
        int end = -1;
        for (int i=0; i<chars.length; i++) {
            if (chars[i] == DELIMITER_CHAR) {
                end = i-1;
                reverseCharsInInclusiveRange(chars, begin, end);
                begin = i+1;
            }
        }
        reverseCharsInInclusiveRange(chars, begin, chars.length-1);
        return new String(chars);
    }
        
    private void reverseCharsInInclusiveRange(char[] chars, int begin, int end) {
        for (int i=begin; i<(end+begin+1)/2; i++) {
            char temp = chars[i];
            chars[i] = chars[begin+end-i];
            chars[begin+end-i] = temp;
        }
    }
}
