class Solution {
    public int kthFactor(int n, int k) {
        
        List<Integer> smallerFactors = new ArrayList<>();
        Deque<Integer> largerFactors = new ArrayDeque<>();
        for (int i=1; i<=Math.floor(Math.sqrt(n)); i++) {
            if (n%i == 0) {
                smallerFactors.add(i);
                int largerFactor = n/i;
                if (i != largerFactor){
                    largerFactors.addFirst(largerFactor);
                }
            }
        }
        if (k > smallerFactors.size()+largerFactors.size()) {
            return -1;
        }
        if (k <= smallerFactors.size()) {
            return smallerFactors.get(k-1);
        }
        for (int i=0; i<k-smallerFactors.size()-1; i++) {
            int f = largerFactors.removeFirst();
        }
        return largerFactors.removeFirst();
    }
}