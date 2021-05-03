class Solution {
    public String longestPalindrome(String s) {
        int maxPalindromeBegin = 0;
        int maxPalindromeEnd = 0;
        final boolean[][] longestPalindromes = new boolean[s.length()][s.length()];
        // moving diagonally
        for (int diagonal=0; diagonal<s.length(); diagonal++) {
            for (int begin=0; begin+diagonal<s.length(); begin++) {
                int end = begin + diagonal;
                if (diagonal == 0) {
                    longestPalindromes[begin][end] = true;
                } else if (diagonal == 1) {
                    longestPalindromes[begin][end] = s.charAt(begin)==s.charAt(end);
                } else {
                    longestPalindromes[begin][end] = longestPalindromes[begin+1][end-1]
                        && s.charAt(begin)==s.charAt(end);
                }
                if (longestPalindromes[begin][end]) {
                    maxPalindromeBegin = begin;
                    maxPalindromeEnd = end;
                }
            }
        }
        return s.substring(maxPalindromeBegin, maxPalindromeEnd+1);
    }
}
