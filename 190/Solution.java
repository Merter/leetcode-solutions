public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int leftMask = Integer.MIN_VALUE;
        int rightMask = 1;
        do {
            int leftBit = n&leftMask;
            int rightBit = n&rightMask;
            if ((leftBit==0 && rightBit!=0) || (leftBit!=0 && rightBit==0)) {
                // swap those two bits
                n = n^leftMask;
                n = n^rightMask;
            }
            leftMask = leftMask >>> 1;
            rightMask = rightMask << 1;
        } while (leftMask > rightMask);
        return n;
    }
}