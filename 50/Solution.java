public class Solution {
    public double myPow(double x, int n) {
        if (x==1 || n==0)
            return 1;
        if (x == -1) {
            if (n%2 == 0)
                return 1;
            return -1;
        }
        if (x == 0) {
            if (n > 0)
                return 0;
            return Double.POSITIVE_INFINITY;
        }
        if (n == Integer.MIN_VALUE) {
            if (x>-1 && x<1)
                return Double.POSITIVE_INFINITY;
            return 0;
        }

        int power = Math.abs(n);
        double result = 1;
        if (power==0)
            return result;
        result = myPow(x, power/2);
        result = result*result;
        if (power%2 == 1)
            result *= x;
        if (n<0)
            result = 1/result;
        return result;
    }
}
