class Solution {
    public int missingNumber(final int[] arr) {
        final int len = arr.length;
        final int diff = (arr[len-1] - arr[0]) / len;
        for (int i=0; i<len-1; i++) {
            final int next = arr[i]+diff;
            if (arr[i+1] != next) {
                return next;
            }
        }
        // only happens if diff==0
        return arr[0];
    }
}
