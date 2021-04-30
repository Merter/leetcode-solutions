class Solution {
    
    
    public int myAtoi(final String s) {
        final String numInString = s.trim();
        if ("".equals(numInString)) {
            return 0;
        }
        long number = 0;
        int sign = 1;
        int i = 0;
        if (numInString.charAt(i) == '+') {
            // skip '+'
            i++;
            // if the immediately following char is not a digit, return 0
            if (! isDigit(numInString, i)) {
                return 0;
            }            
        } else if (numInString.charAt(i) == '-') {
            sign = -1;
            i++;
            // if the immediately following char is not a digit, return 0
            if (! isDigit(numInString, i)) {
                return 0;
            }
        }
        while (isDigit(numInString, i)) {
            number *= 10;
            number += (numInString.charAt(i)-'0');
            i++;
            if (sign==1 && number>=Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (sign==-1 && -number<=Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        return sign * (int)number;
    }
    
    private boolean isDigit(final String str, final int index) {
        return index<str.length() && str.charAt(index)-'0'>=0 && str.charAt(index)-'0'<=9;
    }
}
