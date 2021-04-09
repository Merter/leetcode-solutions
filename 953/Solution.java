class Solution {
        
    public boolean isAlienSorted(final String[] words, final String order) {
        final Map<Character, Integer> char2Order = new HashMap<>();
        for (int i=0; i<order.length(); i++) {
            char2Order.put(order.charAt(i), i);
        }
        for (int i=1; i<words.length; i++) {
            if (! sorted(words[i-1], words[i], char2Order)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean sorted(final String curr, final String next, final Map<Character, Integer> char2Order) {
        for (int i=0; i<curr.length(); i++) {
            if (i == next.length()) {
                // next one has less chars
                return false;
            }
            final char currChar = curr.charAt(i);
            final char nextChar = next.charAt(i);
            if (char2Order.get(currChar) < char2Order.get(nextChar)) {
                return true;
            }
            if (char2Order.get(currChar) > char2Order.get(nextChar)) {
                return false;
            }
        }
        return true;
    }
}