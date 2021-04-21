class Solution {
    public String removeDuplicates(final String str, final int k) {
        final Deque<Character> charDeque = new ArrayDeque<>();
        final Deque<Integer> countStack = new ArrayDeque<>();
        for (final char chr : str.toCharArray()) {
            if (charDeque.isEmpty() || (charDeque.peekLast() != chr)) {
                charDeque.addLast(chr);
                countStack.addLast(1);
                continue;
            }
            final int currentCount = countStack.removeLast() + 1;
            if (currentCount == k) {
                charDeque.removeLast();
            } else {
                countStack.addLast(currentCount);
            }
        }
        final StringBuilder stb = new StringBuilder();
        while (!charDeque.isEmpty()) {
            final char chr = charDeque.removeFirst();
            final int charCount = countStack.removeFirst();
            for (int i=0; i<charCount; i++) {
                stb.append(chr);
            }
        }
        return stb.toString();
    }
}
