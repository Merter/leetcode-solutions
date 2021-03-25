class Solution {
    public int maxProfit(int[] prices) {
        int minBuyPrice = prices[0];
        int maxProfit = Integer.MIN_VALUE;
        for (int day=1; day<prices.length; day++) {
            maxProfit = Math.max(maxProfit, prices[day]-minBuyPrice);
            minBuyPrice = Math.min(minBuyPrice, prices[day]);
        }
        return Math.max(maxProfit, 0);
    }
}