class Solution {
    public boolean hasAllCodes(final String string, final int k) {
        if (string.length() < k) {
            return false;
        }
        final int binaryCodeSize = 1 << k;
        final boolean[] foundNums = new boolean[binaryCodeSize];
        for (int i=0; i<=string.length()-k; i++) {
            final String subString = string.substring(i, i+k);
            final int subInt = Integer.parseInt(subString, 2);
            foundNums[subInt] = true;
        }
        for (int i=0; i<binaryCodeSize; i++) {
            if (foundNums[i] == false) {
                return false;
            }
        }
        return true;
    }
}
