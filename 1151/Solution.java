class Solution {
    public int minSwaps(final int[] data) {
        if (data==null || data.length<2) {
            return 0;
        }
        int oneCount = 0;
        for (final int num : data) {
            oneCount += (num==1) ? 1 : 0;
        }
        final int windowSize = oneCount;
        int zeroCountInWindow = 0;
        for (int i=0; i<windowSize; i++) {
            zeroCountInWindow += (data[i]==0) ? 1 : 0;
        }
        int minSwaps = zeroCountInWindow;
        int currentSwaps = zeroCountInWindow;
        for (int i=1; i+windowSize-1<data.length; i++) {
            if (data[i-1] == 0) zeroCountInWindow--;
            if (data[i+windowSize-1] == 0) zeroCountInWindow++;
            minSwaps = Math.min(minSwaps, zeroCountInWindow);
        }
        return minSwaps;
    }    
}