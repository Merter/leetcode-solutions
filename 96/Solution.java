class Solution {
    private static final int MAX = 20;
    private static final int[] RESULTS = new int[MAX];
    static {
        RESULTS[0] = 1;
        RESULTS[1] = 1;
        for (int currentTreeNodeCount=2; currentTreeNodeCount<MAX; currentTreeNodeCount++) {
            for (int leftSubTreeNodeCount=0; leftSubTreeNodeCount<(currentTreeNodeCount+1)/2; leftSubTreeNodeCount++) {
                int resultForLeft = RESULTS[leftSubTreeNodeCount];
                int rightSubTreeNodeCount = currentTreeNodeCount-1-leftSubTreeNodeCount;
                int resultForRight = RESULTS[rightSubTreeNodeCount];
                int leftRightChange = (leftSubTreeNodeCount==rightSubTreeNodeCount) ? 1 : 2;
                RESULTS[currentTreeNodeCount] += leftRightChange*resultForLeft*resultForRight;
            }
        }
    }
    
    public int numTrees(int n) {
        return RESULTS[n];
    }
}
