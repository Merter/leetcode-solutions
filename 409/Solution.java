class Solution {
    public int longestPalindrome(String str) {
        Map<Character, Integer> char2Count = char2Count(str);
        int longestPalindromeLength = 0;
        int longestOddCharCount = 0;
        for (Map.Entry<Character, Integer> entry : char2Count.entrySet()) {
            int count = entry.getValue();
            if (count%2 == 0) {
                longestPalindromeLength += count;
            } else {
                if (count > longestOddCharCount) {
                    longestPalindromeLength += (longestOddCharCount > 0 ? longestOddCharCount-1 : 0);
                    longestOddCharCount = count;
                } else {
                    longestPalindromeLength += (count-1);
                }
            }
        }
        longestPalindromeLength += longestOddCharCount;
        return longestPalindromeLength;
    }
    
    private Map<Character, Integer> char2Count(String word) {
        Map<Character, Integer> char2Count = new HashMap<>();
        for (int i=0; i<word.length(); i++) {
            char letter = word.charAt(i);
            Integer count = char2Count.get(letter);
            if (count == null) {
                count = 0;
            }
            char2Count.put(letter, ++count);
        }
        return char2Count;
    }
}