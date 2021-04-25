public class Solution {
    
    private static final Map<Character, Integer> ROMAN_LITERALS = new HashMap<Character, Integer>(7);
    static {
        ROMAN_LITERALS.put('I', 1);
        ROMAN_LITERALS.put('V', 5);
        ROMAN_LITERALS.put('X', 10);
        ROMAN_LITERALS.put('L', 50);
        ROMAN_LITERALS.put('C', 100);
        ROMAN_LITERALS.put('D', 500);
        ROMAN_LITERALS.put('M', 1000);
    }
    
    public int romanToInt(String s) {
        int result = 0;
        int prevValue = Integer.MAX_VALUE;
        for (int i=0; i<s.length(); i++) {
            int valueOfRoman = ROMAN_LITERALS.get(s.charAt(i));
            if (valueOfRoman <= prevValue) {
                result += valueOfRoman;
            } else {
                result += (valueOfRoman - 2*prevValue);
            }
            prevValue = valueOfRoman;
        }
        return result;
    }
}
