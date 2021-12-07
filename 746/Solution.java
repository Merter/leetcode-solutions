class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int twoStepsBack = cost[0];
        int oneStepBack = cost[1];
        for (int i=2; i<cost.length; i++) {
            int current = Math.min(twoStepsBack, oneStepBack) + cost[i];
            twoStepsBack = oneStepBack;
            oneStepBack = current;
        }
        return Math.min(twoStepsBack, oneStepBack);
    }
}
