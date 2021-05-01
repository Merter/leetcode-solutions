class Solution {
    
    private static final Map<Character, Character> STROBOGRAMMATIC_DIGITS = new HashMap<>();
    static {
        STROBOGRAMMATIC_DIGITS.put('0', '0');
        STROBOGRAMMATIC_DIGITS.put('1', '1');
        STROBOGRAMMATIC_DIGITS.put('6', '9');
        STROBOGRAMMATIC_DIGITS.put('8', '8');
        STROBOGRAMMATIC_DIGITS.put('9', '6');
    }
    
    public boolean isStrobogrammatic(String num) {
        int left = 0;
        int right = num.length()-1;
        while (right >= left) {
            final char leftChar = num.charAt(left);
            if (! STROBOGRAMMATIC_DIGITS.keySet().contains(leftChar)) {
                return false;
            }
            final char rightChar = num.charAt(right);
            if (! STROBOGRAMMATIC_DIGITS.keySet().contains(rightChar)) {
                return false;
            }
            if (rightChar != STROBOGRAMMATIC_DIGITS.get(leftChar)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }    
}
