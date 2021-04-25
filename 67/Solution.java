class Solution {
    public String addBinary(final String a, final String b) {
        final Deque<Integer> stack = new ArrayDeque<>();
        int carry = 0;
        int aIndexRight = a.length()-1;
        int bIndexRight = b.length()-1;
        while (aIndexRight >= 0) {
            final int aCharValue = a.charAt(aIndexRight--)=='0' ? 0 : 1;
            int result = carry + aCharValue;
            if (bIndexRight >= 0) {
                final int bCharValue = b.charAt(bIndexRight--)=='0' ? 0 : 1;
                result += bCharValue;
            }
            if (result > 1) {
                carry = 1;
                result = result % 2;
            } else {
                carry = 0;
            }
            stack.addLast(result);
        }
        // remaining b
        while (bIndexRight >= 0) {
            final int bCharValue = b.charAt(bIndexRight--)=='0' ? 0 : 1;
            int result = carry + bCharValue;
            if (result > 1) {
                carry = 1;
                result = result % 2;
            } else {
                carry = 0;
            }
            stack.addLast(result);
        }
        // remaining carry
        if (carry == 1) {
            stack.addLast(1);
        }
        // convert stack to result String
        final StringBuilder stb = new StringBuilder();
        while (! stack.isEmpty()) {
            stb.append(stack.removeLast());
        }
        return stb.toString();
    }
}
