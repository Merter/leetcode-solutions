class Solution {
    public int[] constructArray(int n, int k) {
        final int[] kUniqueDiffs = new int[n];
        int kUniqueDiffsIndex = 0;
        for (int i=1; i<n-k; i++) {
            kUniqueDiffs[kUniqueDiffsIndex++] = i;
        }
        for (int i=0; i<=k; i++) {
            kUniqueDiffs[kUniqueDiffsIndex++] = (i%2==0) ? (n-k+i/2) : (n-i/2);
        }
        return kUniqueDiffs;
    }
}
