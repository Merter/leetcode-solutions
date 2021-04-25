class Solution {

    private static int HALF_INT_MIN_VALUE = -1073741824;    
    
    public int divide(int dividend, int divisor) {
        if (dividend==Integer.MIN_VALUE && divisor==-1) {
            return Integer.MAX_VALUE;
        }
        int quotient = 0;
        int negatives = 2;
        if (dividend > 0) {
            dividend = -dividend;
            negatives--;
        }
        if (divisor > 0) {
            divisor = -divisor;
            negatives--;
        }
        while (dividend <= divisor) {
            int powerOfTwo = 1;
            int value = divisor;
            while (value>=HALF_INT_MIN_VALUE && value+value>dividend) {
                value += value;
                powerOfTwo += powerOfTwo;
            }
            dividend -= value;
            quotient += powerOfTwo;
        }
        return negatives==1 ? -quotient : quotient;
    }
}
