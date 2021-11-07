class Solution {
    public int secondHighest(String s) {
        int maxDigit = -1;
        int secondMaxDigit = -1;
        for (int i=0; i<s.length(); i++) {
            int digit = s.charAt(i) - '0';
            if (digit<0 || digit>9) {
                continue;
            }
            if (digit > maxDigit) {
                secondMaxDigit = maxDigit;
                maxDigit = digit;
            } else if (digit!=maxDigit && digit>secondMaxDigit) {
                secondMaxDigit = digit;
            }
        }
        return secondMaxDigit;
    }
}
