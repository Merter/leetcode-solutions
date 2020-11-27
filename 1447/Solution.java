class Solution {
    public List<String> simplifiedFractions(int n) {
        if (n == 1) {
            return new ArrayList<String>();
        }
        List<String> simplifiedFractions = simplifiedFractions(n-1);
        for (int i=1; i<n; i++) {
            if (gcd(i, n) == 1) {
                simplifiedFractions.add(i +"/" + n);
            }
        }
        return simplifiedFractions;        
    }
    
    private int gcd(int smallNum, int bigNum) {
        int remainder = bigNum % smallNum;
        if (remainder == 0) {
            return smallNum;
        }
        return gcd(remainder, smallNum);
    }
}
