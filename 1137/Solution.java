class Solution {
    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 1;
        int threePrev = 0;
        int twoPrev = 1;
        int prev = 1;
        for (int i=3; i<=n; i++) {
            int curr = threePrev+twoPrev+prev;
            threePrev = twoPrev;
            twoPrev = prev;
            prev = curr;
        }
        return prev;
    }
}
