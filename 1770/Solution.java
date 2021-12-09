class Solution {
    private int[] mNums;
    private int[] mMultipliers;
    private int[][] mDp;
    
    public int maximumScore(int[] nums, int[] multipliers) {
        mDp = new int[multipliers.length][multipliers.length];
        mNums = nums;
        mMultipliers = multipliers;
        return maximumScore(0, 0, 0);
    }
    
    private int maximumScore(int begin, int fromEnd, int multipliersIndex) {
        if (multipliersIndex == mMultipliers.length) {
            return 0;
        }
        if (mDp[begin][fromEnd] == 0) {
            mDp[begin][fromEnd] = Math.max(
                mMultipliers[multipliersIndex]*mNums[begin] 
                    + maximumScore(begin+1, fromEnd, multipliersIndex+1),
                mMultipliers[multipliersIndex]*mNums[mNums.length-fromEnd-1] 
                    + maximumScore(begin, fromEnd+1, multipliersIndex+1));
        }
        return mDp[begin][fromEnd];
    }
}
