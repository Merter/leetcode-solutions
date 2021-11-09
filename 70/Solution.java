class Solution {
    public int climbStairs(int n) {
        // fibonacci numbers
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int twoPrev = 1;
        int prev = 2;
        for (int i=3; i<=n ;i++) {
            int curr = twoPrev+prev;
            twoPrev = prev;
            prev = curr;
        }
        return prev;        
    }
}
