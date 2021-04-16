class Solution {
    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int twoPrev = 0;
        int prev = 1;
        for (int i=2; i<=n; i++) {
            int curr = twoPrev+prev;
            twoPrev = prev;
            prev = curr;
        }
        return prev;
    }
}
