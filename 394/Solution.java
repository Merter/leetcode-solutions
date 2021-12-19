class Solution {
    public String decodeString(String s) {
        Deque<Integer> repeatCountStack = new ArrayDeque<>();
        Deque<StringBuilder> partialStringStack = new ArrayDeque<>();
        int repeatCount = 0;
        StringBuilder currentBuilder = new StringBuilder();
        for (int i=0; i<s.length(); i++) {
            char chr = s.charAt(i);
            if (Character.isDigit(chr)  ) {
                repeatCount *= 10;
                repeatCount += Character.getNumericValue(chr);
            } else if (chr == '[') {
                repeatCountStack.push(repeatCount);
                repeatCount = 0;
                partialStringStack.push(currentBuilder);
                currentBuilder = new StringBuilder();
            } else if (chr == ']') {
                repeatCount = repeatCountStack.pop();
                StringBuilder repeatedStringBuilder = new StringBuilder();
                for (int repeat=0; repeat<repeatCount; repeat++) {
                    repeatedStringBuilder.append(currentBuilder.toString());
                }
                if (! partialStringStack.isEmpty()) {
                    StringBuilder prevBuilder = partialStringStack.pop();
                    prevBuilder.append(repeatedStringBuilder.toString());
                    currentBuilder = prevBuilder;
                } else {
                    currentBuilder = repeatedStringBuilder;
                }
                repeatCount = 0;
            } else {    // letter
                currentBuilder.append(chr);
            }
        }
        return currentBuilder.toString();
    }
}
