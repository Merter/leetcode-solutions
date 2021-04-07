class Solution {
    
    private static final Set<Character> VOWELS = new HashSet<>();
    static {
        VOWELS.add('a');
        VOWELS.add('A');
        VOWELS.add('e');
        VOWELS.add('E');
        VOWELS.add('i');
        VOWELS.add('I');
        VOWELS.add('o');
        VOWELS.add('O');
        VOWELS.add('u');
        VOWELS.add('U');
    }
    
    public boolean halvesAreAlike(String s) {
        int vowelCountInFirstHalf = 0;
        int i = 0;
        while (i < s.length()/2) {
            if (VOWELS.contains(s.charAt(i))) {
                vowelCountInFirstHalf++;
            }
            i++;
        }
        while (i < s.length()) {
            if (VOWELS.contains(s.charAt(i))) {
                vowelCountInFirstHalf--;
            }
            i++;
        }
        return vowelCountInFirstHalf==0;
    }
}
