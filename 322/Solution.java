class Solution {
    public int coinChange(final int[] coins, final int requestedAmount) {
        final int[] minNumCoinsForAmount = new int[requestedAmount+1];
        for (int amount=1; amount<=requestedAmount; amount++) {
            int minNumCoins = -1;
            for (final int coin : coins) {
                if (amount>=coin && minNumCoinsForAmount[amount-coin]!=-1) {
                    final int numCoins = minNumCoinsForAmount[amount-coin] + 1;
                    if (minNumCoins==-1 || numCoins<minNumCoins) {
                        minNumCoins = numCoins;
                    }
                }
            }
            minNumCoinsForAmount[amount] = minNumCoins;
        }
        return minNumCoinsForAmount[requestedAmount];
    }
}
