class Solution {
    // Dynamic Programming
    // Time: O(S*N); Where "N" is the number of denominations and "S" is the "amount".
    // For each value ranging from 1~amount, we iterate "N" times.
    // Space: O(S); The maximum size of the dp array is "S".
    
    // Induction Rule: min(dp[amount], dp[amount-coin]+1)
    // The dp list records the smallest coint number for the "amount"
    // The induction rule states that the smallest value is either the current value
    // in the dp array, or the "amount-coin"+1;
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];

        // Update the cells with a large value "Integer.MAX_VALUE" may overflow
        Arrays.fill(dp, amount+1);
        dp[0] = 0;

        for (int i=1; i<=amount; i++) {
            for (int coin: coins) {
                if (i-coin < 0) continue;
                dp[i] = Math.min(dp[i], dp[i-coin]+1);
            }
        }
        
        return dp[amount] == amount+1 ? -1 : dp[amount];
    }

    // Memoization
    // Time: O(S * N) where "S" is the "amount" and "N" is the number of denominations
    // There can be S number of subproblems each with N iterations.
    // Space; O(S);
    public int coinChange_Memoization(int[] coins, int amount) {
        int[] memo = new int[amount+1];
        return coinChangeHelper_Memoizatio(coins, amount, memo);
    }

    private int coinChangeHelper_Memoizatio(int[] coins, int amount, int[] memo) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;
        if(memo[amount] > 0) return memo[amount];

        int minCoins = Integer.MAX_VALUE;
        for (int coin: coins) {
            int count = coinChangeHelper_Memoizatio(coins, amount-coin, memo);
            if (count == -1) continue;
            minCoins = Math.min(minCoins, count+1);
        }
        memo[amount] = minCoins == Integer.MAX_VALUE ? -1 : minCoins;
        return memo[amount];
    }

    // Time: O(S^N) where N is the number of denominations (each problems can be divided into N subproblems);
    // Space: O(N);
    // Brute Force -> Exceed Time Limit
    public int coinChange_BruteFroce(int[] coins, int amount) {
        return coinChangeHelper_BruteFroce(coins, amount);
    }

    private int coinChangeHelper_BruteFroce(int[] coins, int amount) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;

        int minCoins = Integer.MAX_VALUE;
        for (int coin: coins) {
            int count = coinChangeHelper_BruteFroce(coins, amount-coin);
            if (count == -1) continue;
            minCoins = Math.min(minCoins, count+1);
        }
        return (minCoins == Integer.MAX_VALUE) ? -1 : minCoins;
    }
}