class Solution {
    
    public int countPrimes(int n) {
        if (n < 2) {
            return 0;
        }
        boolean[] nonPrime = new boolean[n];
        nonPrime[0] = true;
        nonPrime[1] = true;
        for (int i=2; i<Math.ceil(Math.sqrt(n)); i++) {
            if (nonPrime[i]) {
                continue;
            }
            if (i!=2 && i%2 == 0) {
                nonPrime[i] = true;
                continue;
            }
            for (int coefficient=2; i*coefficient<n; coefficient++) {
                nonPrime[i*coefficient] = true;
            }
        }
        int primeCount = 0;
        for (int i=0; i<n; i++) {
            primeCount += nonPrime[i] ? 0 : 1;
        }
        return primeCount;
    }
}
