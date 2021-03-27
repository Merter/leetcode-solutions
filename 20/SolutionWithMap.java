class SolutionWithMap {
    
    private static final Map<Character, Character> OPEN_2_CLOSE = new HashMap<>();
    static {
        OPEN_2_CLOSE.put('(', ')');
        OPEN_2_CLOSE.put('[', ']');
        OPEN_2_CLOSE.put('{', '}');
    }
    
    public boolean isValid(final String s) {
        final Deque<Character> paranStack = new ArrayDeque<>();
        for (final char chr : s.toCharArray()) {
            final Character closeParan = OPEN_2_CLOSE.get(chr);
            if (closeParan == null) {
                // chr is a closing one
                if (paranStack.isEmpty()) {
                    return false;
                }
                if (chr != paranStack.peek()) {
                    return false;
                }
                paranStack.removeFirst();
            } else {
                paranStack.addFirst(closeParan);
            }
        }
        return paranStack.isEmpty();
    }
}