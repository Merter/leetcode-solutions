class SolutionByDecreasing {

    private static int HALF_INT_MIN_VALUE = -1073741824;    
    
    public int divide(int dividend, int divisor) {
        if (dividend==Integer.MIN_VALUE && divisor==-1) {
            return Integer.MAX_VALUE;
        }
        int negatives = 2;
        if (dividend > 0) {
            dividend = -dividend;
            negatives--;
        }
        if (divisor > 0) {
            divisor = -divisor;
            negatives--;
        }
        int value = divisor;
        int powerOfTwo = 1;
        while (value>=HALF_INT_MIN_VALUE && value+value>=dividend) {
            value += value;
            powerOfTwo += powerOfTwo;
        }
        int quotient = 0;
        while (dividend<=divisor) {
            if (dividend <= value) {
                quotient += powerOfTwo;
                dividend -=value;
            }
            powerOfTwo >>= 1;
            value >>= 1;
        }
        return negatives==1 ? -quotient : quotient;
    }
}
