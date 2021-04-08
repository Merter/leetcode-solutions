class Solution {
    
    private static final String[] DIGIT_2_LETTERS = 
        new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    public List<String> letterCombinations(String digits) {
        List<String> letterCombinations = new ArrayList<>();
        for (int i=0; i<digits.length(); i++) {
            List<String> producedLetterCombinations = new ArrayList<>();
            final char digit = digits.charAt(i);
            final String letters = DIGIT_2_LETTERS[digit-'0'];
            for (int j=0; j<letters.length(); j++) {
                if (letterCombinations.isEmpty()) {
                    letterCombinations.add("");
                }
                for (final String combination : letterCombinations) {
                    producedLetterCombinations.add(combination+letters.charAt(j));
                }
            }
            letterCombinations = producedLetterCombinations;
        }
        return letterCombinations;
    }
}
