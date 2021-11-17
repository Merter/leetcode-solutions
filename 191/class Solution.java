public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int mask = Integer.MIN_VALUE;
        int oneCounter = 0;
        while (mask != 0) {
            oneCounter += (mask&n)==0 ? 0 : 1;
            mask = mask >>> 1;
        }
        return oneCounter;
    }
}
