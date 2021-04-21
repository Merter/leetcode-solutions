class Solution {
    public String removeDuplicates(final String str) {
        final Deque<Character> charDeque = new ArrayDeque<>();
        for (final char chr : str.toCharArray()) {
            if (charDeque.isEmpty() || (charDeque.peekLast() != chr)) {
                charDeque.addLast(chr);
                continue;
            }
            charDeque.removeLast();
        }
        final StringBuilder stb = new StringBuilder();
        while (!charDeque.isEmpty()) {
            final char chr = charDeque.removeFirst();
            stb.append(chr);
        }
        return stb.toString();
    }
}
